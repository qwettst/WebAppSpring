package dev.qwett.webappspring.service.impl;

import dev.qwett.webappspring.entities.Consumer;
import dev.qwett.webappspring.service.ConsumerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class ConsumerServiceImpl implements ConsumerService {

    private static final Logger logger = LoggerFactory.getLogger(ConsumerService.class);

    private final ConsumerRepository consumerRepository;

    ConsumerServiceImpl(ConsumerRepository consumerRepository) {
        this.consumerRepository = consumerRepository;
    }


    public List<Consumer> findAll() {
        logger.info("Search all records in database");
        return consumerRepository.findAll();
    }

    public Consumer findById(int id) {
        logger.info("Find Consumers with id = {}", id);
        return consumerRepository.findById(id).orElse(null);
    }

    public Consumer addConsumer(Consumer consumer) {
        logger.info("Add Consumer...");
        if (consumerRepository.findById(consumer.getIdConsumer()).orElse(null) == null) {
            Consumer resConsumer = consumerRepository.save(consumer);
            logger.info("Consumer with id = {} , was added", resConsumer.getIdConsumer());
            return resConsumer;
        }
        logger.warn("Adding error occurred when adding a Consumer");
        return null;
    }

    public Consumer updateConsumer(int id, Consumer consumer) {
        consumer.setIdConsumer(id);
        logger.info("Updating Consumer with id = {}", id);
        if (consumerRepository.findById(consumer.getIdConsumer()) != null) {
            logger.info("Consumer id = {},  was updated", id);
            return consumerRepository.save(consumer);
        }
        logger.warn("Updating error occurred when update a Consumer with id = {}", id);
        return null;
    }

    public void delete(int id) {
        consumerRepository.deleteById(id);
        logger.info("Consumer id = {}, was deleted", id);
    }

    public List<Consumer> findByName(String name) {
        logger.info("Search for entries, where firstName or lastName like  = {}", name);
        return consumerRepository.findByName(name);
    }
}
