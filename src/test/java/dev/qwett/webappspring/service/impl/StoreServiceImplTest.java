//package dev.qwett.webappspring.service.impl;
//
//import dev.qwett.webappspring.entities.Store;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertNull;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//
//class StoreServiceImplTest {
//
//    private StoreServiceImpl storeService;
//    private StoreRepository storeRepository;
//    private Store store;
//
//    @BeforeEach
//    void init() {
//        storeRepository = mock(StoreRepository.class);
//        storeService = new StoreServiceImpl(storeRepository);
//        store = new Store();
//    }
//
//    @Test
//    void findAll() {
//        List<Store> storeList = new ArrayList<>();
//        when(storeRepository.findAll()).thenReturn(storeList);
//
//        assertNotNull(storeService.findAll());
//
//        verify(storeRepository, times(1)).findAll();
//    }
//
//    @Test
//    void findById() {
//        int id = any(Integer.class);
//        when(storeRepository.findById(id)).thenReturn(java.util.Optional.ofNullable(store));
//
//        assertNotNull(storeService.findById(id));
//
//        verify(storeRepository, times(1)).findById(id);
//    }
//
//    @Test
//    void addStore() {
//        when(storeRepository.save(any(Store.class))).thenReturn(store);
//
//        assertNotNull(storeService.addStore(store));
//
//        verify(storeRepository, times(1)).save(store);
//    }
//
//    @Test
//    void updateStoreNull() {
//        when(storeRepository.findById(store.getIdStore())).thenReturn(null);
//
//        assertNull(storeService.updateStore(store.getIdStore(), store));
//
//        verify(storeRepository, times(1)).findById(store.getIdStore());
//        verify(storeRepository, times(0)).save(store);
//    }
//
//    @Test
//    void updateStore() {
//        when(storeRepository.findById(store.getIdStore())).thenReturn(java.util.Optional.ofNullable(store));
//        when(storeRepository.save(any(Store.class))).thenReturn(store);
//
//        assertNotNull(storeService.updateStore(store.getIdStore(), store));
//
//        verify(storeRepository, times(1)).findById(store.getIdStore());
//        verify(storeRepository, times(1)).save(store);
//    }
//
//    @Test
//    void findByAddress() {
//        String str = any(String.class);
//        List<Store> storeList = new ArrayList<>();
//        when(storeRepository.findByAddress(str)).thenReturn(storeList);
//
//        assertNotNull(storeService.findByAddress(any(String.class)));
//
//        verify(storeRepository, times(1)).findByAddress(str);
//    }
//
//    @Test
//    void delete() {
//        int id = any(Integer.class);
//        storeService.delete(id);
//        verify(storeRepository, times(1)).deleteById(id);
//    }
//}