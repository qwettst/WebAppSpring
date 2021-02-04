package dev.qwett.webappspring.Service.Store;

import dev.qwett.webappspring.Entity.Store;
import dev.qwett.webappspring.Repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {

    private final StoreRepository storeRepository;

    @Autowired
    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public List<Store> findAll() {
        return storeRepository.findAll();
    }

    public Store findById(int id) {
        return storeRepository.findById(id).orElse(null);
    }

    public Store addStore(Store store) {
        if (storeRepository.findById(store.getIdStore()).orElse(null) == null)
            return storeRepository.save(store);
        return null;
    }

    public Store updateStore(int id, Store store) {
        store.setIdStore(id);
        if (storeRepository.findById(store.getIdStore()).orElse(null) != null)
            return storeRepository.save(store);
        return null;
    }

    public void delete(int id) {
        storeRepository.deleteById(id);
    }
}
