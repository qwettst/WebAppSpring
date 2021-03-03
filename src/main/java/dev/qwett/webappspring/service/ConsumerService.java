package dev.qwett.webappspring.service;

import dev.qwett.webappspring.entities.Consumer;

import java.util.List;

public interface ConsumerService {
    List<Consumer> findAll();

    Consumer findById(int id);

    Consumer addConsumer(Consumer consumer);

    Consumer updateConsumer(int id, Consumer consumer);

    void delete(int id);

    List<Consumer> findByName(String name);

    List<Consumer> searchFilter(String name, String lastName, String phone);
}
