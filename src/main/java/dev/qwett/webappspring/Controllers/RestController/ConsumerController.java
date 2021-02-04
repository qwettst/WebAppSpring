package dev.qwett.webappspring.Controllers.RestController;

import dev.qwett.webappspring.Entity.Consumer;
import dev.qwett.webappspring.Service.Store.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("consumers")
public class ConsumerController {

    @Autowired
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
        return consumerService.addStore(consumer);
    }

    @PutMapping("{id}")
    public Consumer update(@PathVariable int id, @RequestBody Consumer consumer) {
        return consumerService.updateStore(id, consumer);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        consumerService.delete(id);
    }

    @GetMapping({"/filtered"})
    public String getByName(HttpServletRequest request, Model model) {
        List<Consumer> consumers = consumerService.filterByName(request.getParameter("name"));
        model.addAttribute("consumers", consumers);
        return "consumer-list";
    }

}
