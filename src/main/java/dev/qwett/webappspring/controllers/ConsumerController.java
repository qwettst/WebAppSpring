package dev.qwett.webappspring.controllers;

import dev.qwett.webappspring.entities.Consumer;
import dev.qwett.webappspring.service.ConsumerService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@RequestMapping("consumers")
public class ConsumerController {

    private final ConsumerService consumerService;

    ConsumerController(ConsumerService consumerService) {
        this.consumerService = consumerService;
    }

    @GetMapping
    public String getAll(Model model) {
        List<Consumer> consumers = consumerService.findAll();
        model.addAttribute("consumers", consumers);
        return "consumers/consumer-list";
    }

    @GetMapping({"/filtered"})
    @PreAuthorize("hasRole(T(dev.qwett.webappspring.entities.model.Role).ADMIN.name())")
    public String getByName(HttpServletRequest request, Model model) {
        List<Consumer> consumers = consumerService.searchFilter(request.getParameter("name"), request.getParameter("lastName"), request.getParameter("phone"));
        model.addAttribute("consumers", consumers);
        return "consumers/consumer-list";
    }

    @GetMapping({"edit/{id}"})
    @PreAuthorize("hasAnyRole(T(dev.qwett.webappspring.entities.model.Role).ADMIN.name(), T(dev.qwett.webappspring.entities.model.Role).USER.name())")
    public String editConsumer(@PathVariable int id, Model model) {
        Consumer consumer = consumerService.findById(id);
        model.addAttribute("consumer", consumer);
        return "consumers/consumer-edit";
    }

    @GetMapping({"/add"})
    @PreAuthorize("hasRole(T(dev.qwett.webappspring.entities.model.Role).ADMIN.name())")
    public String addConsumerForm(Consumer consumer) {
        return "consumers/consumer-add";
    }

    @PostMapping("{id}")
    @PreAuthorize("hasAnyRole(T(dev.qwett.webappspring.entities.model.Role).ADMIN.name(), T(dev.qwett.webappspring.entities.model.Role).USER.name())")
    public String editConsumer(@PathVariable int id, @ModelAttribute("consumer") Consumer consumer) {
        consumerService.updateConsumer(id, consumer);
        return "redirect:/consumers";
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasRole(T(dev.qwett.webappspring.entities.model.Role).ADMIN.name())")
    public String deleteConsumer(@PathVariable int id) {
        consumerService.delete(id);
        return "redirect:/consumers";
    }

    @PutMapping
    @PreAuthorize("hasRole(T(dev.qwett.webappspring.entities.model.Role).ADMIN.name())")
    public String addConsumer(@ModelAttribute("consumer") Consumer consumer) {
        consumerService.addConsumer(consumer);
        return "redirect:/consumers";
    }

}
