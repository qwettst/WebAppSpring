package dev.qwett.service;

import dev.qwett.entities.Store;

import java.util.List;

/**
 * Интерфейс работы репозитория Store с БД
 */
public interface StoreService {
    /**
     * Поиск всех записей в таблице
     *
     * @return все сущности
     */
    List<Store> findAll();

    /**
     * Поиск всех записей в таблице с помощью JDBC API
     *
     * @return все сущности
     */
    List<Store> findAllJDBC();

    /**
     * Поиск сущности по id
     *
     * @param id id искомой записи в таблице
     * @return сущность
     */
    Store findById(int id);

    /**
     * Поиск сущности по id с помощью JPA
     *
     * @param id id искомой записи в таблице
     * @return сущность
     */
    Store findByIdJPA(int id);

    /**
     * Добавление новой сущности в таблицу
     *
     * @param store сущность
     * @return добавленная в таблицу сущность
     */
    Store saveStore(Store store);

    /**
     * Добавление новой сущности в таблицу с помощью JDBC API
     *
     * @param store сущность
     * @return добавленная в таблицу сущность
     */
    Store saveStoreJDBC(Store store);

    /**
     * Добавление новой сущности в таблицу с помощью JPA
     *
     * @param store сущность
     * @return добавленная в таблицу сущность
     */
    Store saveStoreJPA(Store store);

    /**
     * Обновление полуенной сущности
     *
     * @param id    id обновляемой сущности
     * @param store сущность
     * @return обновленная сущность
     */
    Store updateStore(int id, Store store);

    /**
     * Поиск всех сущностей по указанному адрессу
     *
     * @param address имя искмого адресса сущности
     * @return все найденные сущности
     */
    List<Store> findByAddress(String address);

    /**
     * Удаления сущности по id
     *
     * @param id id удаляемой сущности
     */
    void delete(int id);
}
