package dev.qwett.webappspring.service.impl;

import dev.qwett.webappspring.entities.Store;
import dev.qwett.webappspring.service.StoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
class StoreServiceImpl implements StoreService {

    private static final Logger logger = LoggerFactory.getLogger(StoreService.class);

    private final StoreRepository storeRepository;
    private final DataSource dataSource;

    private Connection connection;
    private EntityManager em;

    StoreServiceImpl(StoreRepository storeRepository, DataSource dataSource) {
        this.storeRepository = storeRepository;
        this.dataSource = dataSource;
        try {
            this.connection = dataSource.getConnection();
        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
            throwables.printStackTrace();
        }
    }

    @PersistenceContext
    public void setEm(EntityManager em) {
        this.em = em;
    }

    //    public List<Store> findAll() {
//        logger.info("Search all records in database");
//        return storeRepository.findAll();
//    }
//
//    public Store findById(int id) {
//        if (id < 0) {
//            logger.warn("invalid id , {} < 0", id);
//            return null;
//        }
//        logger.info("Find Store with id = {}", id);
//        return storeRepository.findById(id).orElse(null);
//    }
//
//    public Store addStore(Store store) {
//        logger.info("Add store...");
//        if (store.getAddress() != null && !store.getAddress().trim().isEmpty()) {
//            if (storeRepository.findById(store.getIdStore()).orElse(null) == null) {
//                store = storeRepository.save(store);
//                logger.info("Store with address = {} , was added", store.getAddress());
//                return store;
//            }
//            logger.warn("Adding error occurred, Store address = {}, this store is already in DB", store.getAddress());
//            return null;
//        }
//        logger.warn("Adding error occurred, Field address is empty");
//        return null;
//    }
//
    public Store updateStore(int id, Store store) {
        logger.info("Updating Store with id = {}", id);
        if (id < 0) {
            logger.warn("invalid id , {} < 0", id);
        } else if (store.getAddress() != null && !store.getAddress().trim().isEmpty()) {
            store.setIdStore(id);
            if (storeRepository.findById(store.getIdStore()).isPresent()) {
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

    public List<Store> findAll() {
        String sql = "SELECT * FROM Store";
        logger.info("Search all records in database");
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            List<Store> storeList = new ArrayList<>();
            while (resultSet.next()) {

                Store store = new Store();

                store.setIdStore(resultSet.getInt("id_Store"));
                store.setAddress(resultSet.getString("Address"));

                storeList.add(store);
            }
            return storeList;
        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
            throwables.printStackTrace();
        }
        return null;
    }

    public Store addStore(Store store) {
        logger.info("Add store...");
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Store VALUES(?, ?)")) {
            preparedStatement.setInt(1, getCountRow());
            preparedStatement.setString(2, store.getAddress());

            preparedStatement.executeUpdate();
            logger.info("Store with address = {} , was added", store.getAddress());
        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
            throwables.printStackTrace();
        }
        return store;
    }

    @Transactional
    public Store saveStore(Store store) {
        logger.info("Add store...");
        if (store.getAddress() != null && !store.getAddress().trim().isEmpty()) {
            if (findById(store.getIdStore()) == null) {
                em.persist(store);
                em.flush();
                logger.info("Store with address = {} , was added", store.getAddress());
                return store;
            }
        }
        logger.warn("Adding error occurred, Store address = {}, this store is already in DB", store.getAddress());
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

    private int getCountRow() {
        int countRow = 0;
        String sql = "SELECT COUNT(id_Store) FROM STORE";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            resultSet.next();
            countRow = resultSet.getInt(1);
        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
            throwables.printStackTrace();
        }
        return ++countRow;
    }

    public Store findById(int id) {
        if (id < 0) {
            logger.warn("invalid id , {} < 0", id);
            return null;
        }
        TypedQuery<Store> query = em.createQuery("SELECT store FROM Store store where store.idStore = :id", Store.class);
        query.setParameter("id", id);
        logger.info("Find Store with id = {}", id);
        return query.getResultList().stream().findAny().orElse(null);
    }
}
