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
        return storeService.findAllJDBC();
    }

    @GetMapping({"/filtered"})
    public List<Store> getByName(@RequestParam(value = "name") String address) {
        return storeService.findByAddress(address);
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
