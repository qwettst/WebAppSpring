package dev.qwett.webappspring.controller;

import dev.qwett.webappspring.Service.Store.ConsumerService;
import dev.qwett.webappspring.entity.Consumer;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("{id}")
    public Consumer getOne(@PathVariable("id") int id) {
        return consumerService.findById(id);
    }

    @PostMapping
    public Consumer add(@RequestBody Consumer consumer) {
        return consumerService.addConsumer(consumer);
    }

    @PutMapping("{id}")
    public Consumer update(@PathVariable int id, @RequestBody Consumer consumer) {
        return consumerService.updateConsumer(id, consumer);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        consumerService.delete(id);
    }

    @GetMapping({"/filtered"})
    public String getByName(HttpServletRequest request, Model model) {
        List<Consumer> consumers = consumerService.findByName(request.getParameter("name"));
        model.addAttribute("consumers", consumers);
        return "consumer-list";
    }

}
