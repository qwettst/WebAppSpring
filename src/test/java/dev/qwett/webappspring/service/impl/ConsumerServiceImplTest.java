package dev.qwett.webappspring.service.impl;

import dev.qwett.webappspring.entities.Consumer;
import dev.qwett.webappspring.service.ConsumerService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

class ConsumerServiceImplTest {

    private ConsumerService consumerService;
    private ConsumerRepository consumerRepository;
    private Consumer consumer;

    @BeforeEach
    void init() {
        consumerRepository = Mockito.mock(ConsumerRepository.class);
        consumerService = new ConsumerServiceImpl(consumerRepository);
        consumer = new Consumer();
    }


    @Test
    void findAll() {
        List<Consumer> consumerList = new ArrayList<>();
        Mockito.when(consumerRepository.findAll()).thenReturn(consumerList);
        Assert.assertNotNull(consumerRepository.findAll());
        Mockito.verify(consumerRepository, Mockito.times(1)).findAll();
    }

    @Test
    void findById() {
        int id = any(Integer.class);
        Mockito.when(consumerRepository.findById(id)).thenReturn(java.util.Optional.ofNullable(consumer));
        Assert.assertNotNull(consumerService.findById(id));
        Mockito.verify(consumerRepository, Mockito.times(1)).findById(id);
    }

    @Test
    void addConsumer() {
        Mockito.when(consumerRepository.save(consumer)).thenReturn(consumer);
        Assert.assertNotNull(consumerService.addConsumer(consumer));
        Mockito.verify(consumerRepository, Mockito.times(1)).save(consumer);
    }

    @Test
    void updateConsumer() {
        Mockito.when(consumerRepository.findById(consumer.getIdConsumer())).thenReturn(java.util.Optional.ofNullable(consumer));
        Mockito.when(consumerRepository.save(consumer)).thenReturn(consumer);
        Assert.assertNotNull(consumerService.updateConsumer(consumer.getIdConsumer(), consumer));
        Mockito.verify(consumerRepository, Mockito.times(1)).findById(consumer.getIdConsumer());
        Mockito.verify(consumerRepository, Mockito.times(1)).save(consumer);
    }

    @Test
    void updateConsumerNull() {
        Mockito.when(consumerRepository.findById(consumer.getIdConsumer())).thenReturn(null);
        Assert.assertNull(consumerService.updateConsumer(consumer.getIdConsumer(), consumer));
        Mockito.verify(consumerRepository, Mockito.times(1)).findById(consumer.getIdConsumer());
        Mockito.verify(consumerRepository, Mockito.times(0)).save(consumer);
    }

    @Test
    void delete() {
        int id = any(Integer.class);
        consumerService.delete(id);
        Mockito.verify(consumerRepository, Mockito.times(1)).deleteById(id);
    }

    @Test
    void findByName() {
        String str = any(String.class);
        List<Consumer> consumerList = new ArrayList<>();
        Mockito.when(consumerRepository.findByName(str)).thenReturn(consumerList);
        Assert.assertNotNull(consumerService.findByName(any(String.class)));
        Mockito.verify(consumerRepository, Mockito.times(1)).findByName(str);

    }
}