package dev.qwett.controllers;

import dev.qwett.entities.Store;
import dev.qwett.service.StoreService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        List<Store> stores = storeService.findAllJDBC();
        model.addAttribute("stores", stores);
        return "stores/store-list";
    }

    @GetMapping({"/filtered"})
    @PreAuthorize("hasRole(T(dev.qwett.security.model.Role).ADMIN.name())")
    public String getByName(HttpServletRequest request, Model model, RedirectAttributes redirAttrs) {
        List<Store> stores = storeService.findByAddress(request.getParameter("address"));
        if (stores == null) {
            redirAttrs.addFlashAttribute("message", "Поле поиска пустое");
            return "redirect:/stores";
        } else
            model.addAttribute("stores", stores);
        return "stores/store-list";
    }

    @GetMapping({"edit/{id}"})
    @PreAuthorize("hasAnyRole(T(dev.qwett.security.model.Role).ADMIN.name(), " +
            "T(dev.qwett.security.model.Role).USER.name())")
    public String editStore(@PathVariable int id, Model model) {
        Store store = storeService.findByIdJPA(id);
        model.addAttribute("store", store);
        return "stores/store-edit";
    }

    @GetMapping({"/add"})
    @PreAuthorize("hasRole(T(dev.qwett.security.model.Role).ADMIN.name())")
    public String addStoreForm(Store store) {
        return "stores/store-add";
    }

    @PostMapping("{id}")
    @PreAuthorize("hasAnyRole(T(dev.qwett.security.model.Role).ADMIN.name(), " +
            "T(dev.qwett.security.model.Role).USER.name())")
    public String editStore(@PathVariable int id, @ModelAttribute("store") Store store, RedirectAttributes redirAttrs) {
        if (storeService.updateStore(id, store) != null)
            return "redirect:/stores";
        else {
            redirAttrs.addFlashAttribute("message", "Обновление не удалось");
            return "redirect:/stores/edit/{id}";
        }
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasRole(T(dev.qwett.security.model.Role).ADMIN.name())")
    public String deleteStore(@PathVariable int id) {
        storeService.delete(id);
        return "redirect:/stores";
    }

    @PutMapping
    @PreAuthorize("hasRole(T(dev.qwett.security.model.Role).ADMIN.name())")
    public String addStore(@ModelAttribute("store") Store store, RedirectAttributes redirAttrs) {
        if (store.getAddress() != null && !store.getAddress().trim().isEmpty()) {
            storeService.saveStoreJPA(store);
            return "redirect:/stores";
        }
        redirAttrs.addFlashAttribute("message", "Поле Адрес не должно быть пустым");
        return "redirect:/stores/add";
    }
}
