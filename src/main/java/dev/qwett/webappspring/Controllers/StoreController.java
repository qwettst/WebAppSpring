package dev.qwett.webappspring.Controllers;

import dev.qwett.webappspring.Entity.Store;
import dev.qwett.webappspring.Repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StoreController {
    private final StoreRepository storeRepository;

    @Autowired
    public StoreController(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @GetMapping("/Stores")
    public List<Store> getAll(){
        return storeRepository.findAll();
    }
}
