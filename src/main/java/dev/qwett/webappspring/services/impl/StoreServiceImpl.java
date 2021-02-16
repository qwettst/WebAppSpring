package dev.qwett.webappspring.services.impl;

import dev.qwett.webappspring.entities.Store;
import dev.qwett.webappspring.services.StoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {

    private static final Logger logger = LoggerFactory.getLogger(StoreService.class);

    private final StoreRepository storeRepository;

    StoreServiceImpl(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @PreAuthorize("hasRole(T(dev.qwett.webappspring.entities.model.Role).ADMIN.name())")
    public List<Store> findAll() {
        logger.info("Search all records in database");
        return storeRepository.findAll();
    }

    public Store findById(int id) {
        if (id < 0) {
            logger.warn("invalid id , {} < 0", id);
            return null;
        }
        logger.info("Find Store with id = {}", id);
        return storeRepository.findById(id).orElse(null);
    }

    public Store addStore(Store store) {
        logger.info("Add store...");
        if (store.getAddress() != null && !store.getAddress().trim().isEmpty()) {
            if (storeRepository.findById(store.getIdStore()).orElse(null) == null) {
                store = storeRepository.save(store);
                logger.info("Store with address = {} , was added", store.getAddress());
                return store;
            }
            logger.warn("Adding error occurred, Store address = {}, this store is already in DB", store.getAddress());
            return null;
        }
        logger.warn("Adding error occurred, Field address is empty");
        return null;
    }

    public Store updateStore(int id, Store store) {
        logger.info("Updating Store with id = {}", id);
        if (id < 0) {
            logger.warn("invalid id , {} < 0", id);
        } else if (store.getAddress() != null && !store.getAddress().trim().isEmpty()) {
            store.setIdStore(id);
            if (storeRepository.findById(store.getIdStore()) != null) {
                store = storeRepository.save(store);
                logger.info("Store id = {}, with Address = {},  was updated", id, store.getAddress());
                return store;
            }
            logger.warn("Updating error occurred, Store id = {}, Address = {}, no field found (ID)", id, store.getAddress());
            return null;
        } else
            logger.warn("Field address is empty, update failed");
        return null;
    }

    @Override
    public List<Store> findByAddress(String address) {
        if (address != null && !address.trim().isEmpty()) {
            logger.info("Search for entries, where store address = {}", address);
            return storeRepository.findByAddress(address);
        }
        logger.warn("Field address is empty");
        return null;
    }

    public void delete(int id) {
        if (id < 0)
            logger.warn("invalid id , {} < 0", id);
        else {
            long repoCount = storeRepository.count();
            storeRepository.deleteById(id);
            if (repoCount > storeRepository.count())
                logger.info("Store id = {}, was deleted", id);
            else
                logger.warn("Store id = {} is not deleted", id);
        }
    }
}
