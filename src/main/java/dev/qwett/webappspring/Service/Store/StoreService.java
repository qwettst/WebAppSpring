package dev.qwett.webappspring.Service.Store;

import dev.qwett.webappspring.entity.Consumer;
import dev.qwett.webappspring.entity.Store;

import java.util.List;

public interface StoreService {
    List<Store> findAll();

    Store findById(int id);

    Store addStore(Store store);

    Store updateStore(int id, Store store);

    List<Store> findByAddress(String address);

    void delete(int id);
}
