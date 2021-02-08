package dev.qwett.webappspring.controllers;

import dev.qwett.webappspring.entities.Store;
import dev.qwett.webappspring.service.StoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("stores")
public class StoreController {

    private final StoreService storeService;

    StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping
    public String getAll(Model model) {
        List<Store> stores = storeService.findAll();
        model.addAttribute("stores", stores);
        return "stores/store-list";
    }

    @GetMapping({"/filtered"})
    public String getByName(HttpServletRequest request, Model model) {
        List<Store> stores = storeService.findByAddress(request.getParameter("address"));
        model.addAttribute("stores", stores);
        return "stores/store-list";
    }

    @GetMapping({"edit/{id}"})
    public String editStore(@PathVariable int id, Model model) {
        Store store = storeService.findById(id);
        model.addAttribute("store", store);
        return "stores/store-edit";
    }

    @GetMapping({"/add"})
    public String addStoreForm(Store store) {
        return "stores/store-add";
    }

    @PostMapping("{id}")
    public String editStore(@PathVariable int id, @ModelAttribute("store") Store store) {
        storeService.updateStore(id, store);
        return "redirect:/stores";
    }

    @DeleteMapping("{id}")
    public String deleteStore(@PathVariable int id) {
        storeService.delete(id);
        return "redirect:/stores";
    }

    @PutMapping
    public String addStore(@ModelAttribute("store") Store store) {
        storeService.addStore(store);
        return "redirect:/stores";
    }
}
