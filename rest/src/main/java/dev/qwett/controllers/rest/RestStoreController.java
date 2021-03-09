package dev.qwett.controllers.rest;

import dev.qwett.entities.Store;
import dev.qwett.service.StoreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rest/stores")
public class RestStoreController {

    private final StoreService storeService;

    RestStoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping
    public List<Store> getAll() {
        List<Store> stores = storeService.findAllJDBC();
        return stores;
    }

    @GetMapping({"/filtered{address}"})
    public List<Store> getByName(@PathVariable String address) {
        List<Store> stores = storeService.findByAddress(address);
        return stores;
    }

    @PostMapping("{id}")
    public Store editStore(@PathVariable int id, @RequestBody Store store) {
        return storeService.updateStore(id, store);
    }

    @DeleteMapping("{id}")
    public void deleteStore(@PathVariable int id) {
        storeService.delete(id);
    }

    @PutMapping
    public Store addStore(@RequestBody Store store) {
        return storeService.saveStoreJPA(store);
    }
}
