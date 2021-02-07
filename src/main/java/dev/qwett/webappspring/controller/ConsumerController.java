package dev.qwett.webappspring.controller;

import dev.qwett.webappspring.Service.Store.ConsumerService;
import dev.qwett.webappspring.entity.Consumer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@RequestMapping("consumers")
public class ConsumerController {

    private final ConsumerService consumerService;

    public ConsumerController(ConsumerService consumerService) {
        this.consumerService = consumerService;
    }

    @GetMapping
    public String getAll(Model model) {
        List<Consumer> consumers = consumerService.findAll();
        model.addAttribute("consumers", consumers);
        return "consumer-list";
    }

    @GetMapping({"/filtered"})
    public String getByName(HttpServletRequest request, Model model) {
        List<Consumer> consumers = consumerService.findByName(request.getParameter("name"));
        model.addAttribute("consumers", consumers);
        return "consumer-list";
    }

    @GetMapping({"edit/{id}"})
    public String editConsumer(@PathVariable int id, Model model) {
        Consumer consumer = consumerService.findById(id);
        model.addAttribute("consumer", consumer);
        return "consumer-edit";
    }

    @GetMapping({"/add"})
    public String addConsumerForm(Consumer consumer) {
        return "consumer-add";
    }

    @PutMapping("{id}")
    public String editConsumer(@PathVariable int id, @ModelAttribute("consumer") Consumer consumer) {
        consumerService.updateConsumer(id, consumer);
        return "redirect:/consumers";
    }

    @DeleteMapping("{id}")
    public String deleteConsumer(@PathVariable int id) {
        consumerService.delete(id);
        return "redirect:/consumers";
    }

    @PostMapping
    public String addConsumer(@ModelAttribute("consumer") Consumer consumer) {
        consumerService.addConsumer(consumer);
        return "redirect:/consumers";
    }

}
