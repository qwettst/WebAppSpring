package dev.qwett.webappspring.controller.rest;

import dev.qwett.webappspring.Service.Store.StoreService;
import dev.qwett.webappspring.entity.Store;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("stores")
public class StoreController {

    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping
    public List<Store> getAll() {
        return storeService.findAll();
    }

    @GetMapping("{id}")
    public Store getOne(@PathVariable("id") int id) {
        return storeService.findById(id);
    }

    @PostMapping
    public Store add(@RequestBody Store store) {
        return storeService.addStore(store);
    }

    @PutMapping("{id}")
    public Store update(@PathVariable int id, @RequestBody Store store) {
        return storeService.updateStore(id, store);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        storeService.delete(id);
    }

}
