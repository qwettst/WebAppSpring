package dev.qwett.service;

import dev.qwett.entities.Consumer;

import java.util.List;

/**
 * Интерфейс работы репозитория Consumer с БД
 */
public interface ConsumerService {
    /**
     * Поиск всех записей в таблице
     *
     * @return все сущности
     */
    List<Consumer> findAll();

    /**
     * Поиск сущности по id
     *
     * @param id id искомой записи в таблице
     * @return сущность
     */
    Consumer findById(int id);

    /**
     * Поиск сущности по id с помощью JDBC API
     *
     * @param id id искомой записи в таблице
     * @return сущность
     */
    Consumer findByIdJDBC(int id);

    /**
     * Добавление новой сущности в таблицу
     *
     * @param consumer сущность
     * @return добавленная в таблицу сущность
     */
    Consumer saveConsumer(Consumer consumer);

    /**
     * Добавление новой сущности в таблицу с помощью JPA
     *
     * @param consumer сущность
     * @return добавленная в таблицу сущность
     */
    Consumer saveConsumerJPA(Consumer consumer);

    /**
     * Обновление полуенной сущности
     *
     * @param id       id обновляемой сущности
     * @param consumer сущность
     * @return обновленная сущность
     */
    Consumer updateConsumer(int id, Consumer consumer);

    /**
     * Удаления сущности по id
     *
     * @param id id удаляемой сущности
     */
    void delete(int id);

    /**
     * Поиск всех сущностей по указанному имени
     *
     * @param name имя или фамилия искомой сущности
     * @return все найденные сущности
     */
    List<Consumer> findByName(String name);

    /**
     * Фильтр поиска сущностей
     * (name AND lastname) OR phone
     *
     * @param name     искомое имя в сущности
     * @param lastName искомая фамилия в сущности
     * @param phone    искомойц номер в сущности
     * @return все найденные сущности
     */
    List<Consumer> searchFilter(String name, String lastName, String phone);
}
