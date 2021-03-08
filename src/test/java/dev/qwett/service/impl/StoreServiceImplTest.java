//package dev.qwett.service.impl;
//
//import dev.qwett.entities.Store;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import dev.qwett.service.impl.StoreRepository;
//import dev.qwett.service.impl.StoreServiceImpl;
//
//import javax.persistence.EntityManager;
//import javax.persistence.TypedQuery;
//import javax.sql.DataSource;
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.Assert.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//
//class StoreServiceImplTest {
//
//    private StoreServiceImpl storeService;
//    private StoreRepository storeRepository;
//    private EntityManager entityManager;
//    private DataSource dataSource;
//    private TypedQuery query;
//    private Connection connection;
//    private Store store;
//
//    @BeforeEach
//    void init() {
//        storeRepository = mock(StoreRepository.class);
//        entityManager = mock(EntityManager.class);
//        dataSource = mock(DataSource.class);
//        query = mock(TypedQuery.class);
//        connection = mock(Connection.class);
//        try {
//            when(dataSource.getConnection()).thenReturn(connection);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        storeService = spy(new StoreServiceImpl(storeRepository, dataSource));
//        storeService.setEm(entityManager);
//        store = new Store();
//        store.setAddress("dasda");
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
//    void findAllJDBC() {
//        List<Store> storeList = new ArrayList<>();
//        Statement statement = mock(Statement.class);
//        ResultSet resultSet = mock(ResultSet.class);
//        when(storeRepository.findAll()).thenReturn(storeList);
//        try {
//            when(connection.createStatement()).thenReturn(statement);
//            when(statement.executeQuery(anyString())).thenReturn(resultSet);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        assertNotNull(storeService.findAll());
//    }
//
//    @Test
//    void findByIdJDBC() {
//        int id = any(Integer.class);
//        when(storeRepository.findById(store.getIdStore())).thenReturn(Optional.ofNullable(store));
//        when(entityManager.createQuery(anyString(), any())).thenReturn(query);
//
//        assertTrue(storeRepository.findById(id).isPresent());
//
//        verify(storeRepository, times(1)).findById(id);
//    }
//
////    @Test
////    void saveStore() {
////        PreparedStatement preparedStatement = mock(PreparedStatement.class);
////        when(storeRepository.save(store)).thenReturn(store);
////        try {
////            when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
////        } catch (SQLException throwables) {
////            throwables.printStackTrace();
////        }
////
////        assertNotNull(storeService.saveStoreJDBC(store));
////
////        verify(storeRepository, times(1)).save(store);
////    }
//
//    @Test
//    void updateStoreNull() {
//        when(storeRepository.findById(store.getIdStore())).thenReturn(Optional.empty());
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
//        String str = "address";
//        List<Store> storeList = new ArrayList<>();
//        when(storeRepository.findByAddress(str)).thenReturn(storeList);
//
//        assertNotNull(storeService.findByAddress(str));
//
//        verify(storeRepository, times(1)).findByAddress(str);
//    }
//
//    @Test
//    void delete() {
//        storeService.delete(0);
//        verify(storeRepository, times(1)).deleteById(anyInt());
//    }
//}