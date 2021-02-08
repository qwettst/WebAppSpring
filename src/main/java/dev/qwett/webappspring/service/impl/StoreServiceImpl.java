package dev.qwett.webappspring.service.impl;

import dev.qwett.webappspring.entities.Store;
import dev.qwett.webappspring.service.StoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class StoreServiceImpl implements StoreService {

    private static final Logger logger = LoggerFactory.getLogger(StoreService.class);

    private final StoreRepository storeRepository;

    StoreServiceImpl(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public List<Store> findAll() {
        logger.info("Search all records in database");
        return storeRepository.findAll();
    }

    public Store findById(int id) {
        logger.info("Find Store with id = {}", id);
        return storeRepository.findById(id).orElse(null);
    }

    public Store addStore(Store store) {
        logger.info("Add store...");
        if (storeRepository.findById(store.getIdStore()).orElse(null) == null) {
            logger.info("Store with address = {} , was added", store.getAddress());
            return storeRepository.save(store);
        }
        logger.warn("Adding error occurred, Store address = {}", store.getAddress());
        return null;
    }

    public Store updateStore(int id, Store store) {
        store.setIdStore(id);
        logger.info("Updating Store with id = {}", id);
        if (storeRepository.findById(store.getIdStore()).orElse(null) != null) {
            logger.info("Store id = {}, with Address = {},  was updated", id, store.getAddress());
            return storeRepository.save(store);
        }
        logger.warn("Updating error occurred, Store id = {}, Address = {}", id, store.getAddress());
        return null;
    }

    @Override
    public List<Store> findByAddress(String address) {
        logger.info("Search for entries, where store address = {}", address);
        return storeRepository.findByAddress(address);
    }

    public void delete(int id) {
        storeRepository.deleteById(id);
        logger.info("Store id = {}, was deleted", id);
    }
}
