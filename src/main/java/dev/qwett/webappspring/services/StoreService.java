package dev.qwett.webappspring.services;

import dev.qwett.webappspring.entities.Store;

import java.util.List;

public interface StoreService {
    List<Store> findAll();

    Store findById(int id);

    Store addStore(Store store);

    Store updateStore(int id, Store store);

    List<Store> findByAddress(String address);

    void delete(int id);
}
