package dev.qwett.webappspring.dao;

import dev.qwett.webappspring.entities.Store;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class StoreDAO {

    private static final String URL = "jdbc:h2:mem:testdb";
    private static final String USERNAME = "qwe";
    private static final String PASSWORD = "qwe";

    private static Connection connection;

    @PersistenceContext
    private EntityManager em;

    static {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Store> showAll() {
        List<Store> storeList = new ArrayList<>();
        String sql = "SELECT * FROM Store";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Store store = new Store();

                store.setIdStore(resultSet.getInt("id_Store"));
                store.setAddress(resultSet.getString("Address"));

                storeList.add(store);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return storeList;
    }

    public Store addStore(Store store) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Store VALUES(?, ?)")) {
            preparedStatement.setInt(1, getCountRow());
            preparedStatement.setString(2, store.getAddress());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return store;
    }

    public Store saveStore(Store store) {
        if (store.getAddress() != null && !store.getAddress().trim().isEmpty()) {
            if (findById(store.getIdStore()) == null) {
                em.persist(store);
                em.flush();
                return store;
            }
            return null;
        }
        return null;
    }

    private int getCountRow() {
        int countRow = 0;
        String sql = "SELECT COUNT(id_Store) FROM STORE";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            resultSet.next();
            countRow = resultSet.getInt(1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return countRow += 1;
    }

    public Store findById(int id) {
        TypedQuery<Store> query = em.createQuery("SELECT store FROM Store store where store.idStore = :id", Store.class);
        query.setParameter("id", id);
        return query.getResultList().stream().findAny().orElse(null);
    }
}
