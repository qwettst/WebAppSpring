package dev.qwett.webappspring.service.impl;

import dev.qwett.webappspring.entities.Store;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

class StoreServiceImplTest {


    private StoreServiceImpl storeService;
    private StoreRepository storeRepository;
    private Store store;

    @BeforeEach
    void init() {
        storeRepository = Mockito.mock(StoreRepository.class);
        storeService = new StoreServiceImpl(storeRepository);
        store = new Store();
    }

    @Test
    void findAll() {
        List<Store> storeList = new ArrayList<>();
        Mockito.when(storeRepository.findAll()).thenReturn(storeList);
        Assert.assertNotNull(storeService.findAll());
        Mockito.verify(storeRepository, Mockito.times(1)).findAll();
    }

    @Test
    void findById() {
        int id = any(Integer.class);
        Mockito.when(storeRepository.findById(id)).thenReturn(java.util.Optional.ofNullable(store));
        Assert.assertNotNull(storeService.findById(id));
        Mockito.verify(storeRepository, Mockito.times(1)).findById(id);
    }

    @Test
    void addStore() {
        Mockito.when(storeRepository.save(any(Store.class))).thenReturn(store);
        Assert.assertNotNull(storeService.addStore(store));
        Mockito.verify(storeRepository, Mockito.times(1)).save(store);
    }

    @Test
    void updateStoreNull() {
        Mockito.when(storeRepository.findById(store.getIdStore())).thenReturn(null);
        Assert.assertNull(storeService.updateStore(store.getIdStore(), store));
        Mockito.verify(storeRepository, Mockito.times(1)).findById(store.getIdStore());
        Mockito.verify(storeRepository, Mockito.times(0)).save(store);
    }

    @Test
    void updateStore() {
        Mockito.when(storeRepository.findById(store.getIdStore())).thenReturn(java.util.Optional.ofNullable(store));
        Mockito.when(storeRepository.save(any(Store.class))).thenReturn(store);
        Assert.assertNotNull(storeService.updateStore(store.getIdStore(), store));
        Mockito.verify(storeRepository, Mockito.times(1)).findById(store.getIdStore());
        Mockito.verify(storeRepository, Mockito.times(1)).save(store);
    }

    @Test
    void findByAddress() {
        String str = any(String.class);
        List<Store> storeList = new ArrayList<>();
        Mockito.when(storeRepository.findByAddress(str)).thenReturn(storeList);
        Assert.assertNotNull(storeService.findByAddress(any(String.class)));
        Mockito.verify(storeRepository, Mockito.times(1)).findByAddress(str);
    }

    @Test
    void delete() {
        int id = any(Integer.class);
        storeService.delete(id);
        Mockito.verify(storeRepository, Mockito.times(1)).deleteById(id);
    }
}