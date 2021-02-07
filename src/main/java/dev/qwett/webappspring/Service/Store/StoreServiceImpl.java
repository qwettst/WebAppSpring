package dev.qwett.webappspring.Service.Store;

import dev.qwett.webappspring.entity.Store;
import dev.qwett.webappspring.repository.StoreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;

    public StoreServiceImpl(StoreRepository storeRepository) {
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

    @Override
    public List<Store> findByAddress(String address) {
        return storeRepository.findByAddress(address);
    }

    public void delete(int id) {
        storeRepository.deleteById(id);
    }
}
