package dev.qwett.webappspring.dao;

import dev.qwett.webappspring.entities.Store;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class StoreDAO {

    private static final String URL = "jdbc:h2:mem:testdb";
    private static final String USERNAME = "qwe";
    private static final String PASSWORD = "qwe";

    private static Connection connection;

    static {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Store> showAll() {
        List<Store> storeList = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM Store";
            ResultSet resultSet = statement.executeQuery(SQL);
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
        try {
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement("INSERT INTO Store VALUES(?, ?)");

            preparedStatement.setInt(1, getCountRow());
            preparedStatement.setString(2, store.getAddress());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return store;
    }

    private int getCountRow() {
        int countRow = 0;
        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT COUNT(id_Store) FROM STORE";
            ResultSet resultSet = statement.executeQuery(SQL);
            resultSet.next();
            countRow = resultSet.getInt(1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return countRow += 1;
    }
}
