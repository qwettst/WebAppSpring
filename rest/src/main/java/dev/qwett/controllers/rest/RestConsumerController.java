package dev.qwett.controllers.rest;

import dev.qwett.entities.Consumer;
import dev.qwett.service.ConsumerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rest/consumers")
public class RestConsumerController {

    private final ConsumerService consumerService;

    RestConsumerController(ConsumerService consumerService) {
        this.consumerService = consumerService;
    }

    @GetMapping
    public List<Consumer> getAll() {
        List<Consumer> consumers = consumerService.findAll();
        return consumers;
    }

    @GetMapping({"/filtered{name}&{lastName}&{phone}"})
    public List<Consumer> getByName(@PathVariable String name, @PathVariable String lastName, @PathVariable String phone) {
        List<Consumer> consumers = consumerService.searchFilter(name, lastName, phone);
        return consumers;
    }

    @PostMapping("{id}")
    public Consumer editConsumer(@PathVariable int id, @RequestBody Consumer consumer) {
        return consumerService.updateConsumer(id, consumer);
    }

    @DeleteMapping("{id}")
    public void deleteConsumer(@PathVariable int id) {
        consumerService.delete(id);
    }

    @PutMapping
    public Consumer addConsumer(@RequestBody Consumer consumer) {
        return consumerService.saveConsumerJPA(consumer);
    }
}
