package dev.qwett.webappspring.services.impl;

import dev.qwett.webappspring.entities.Consumer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ConsumerServiceImplTest {

    private ConsumerServiceImpl consumerService;
    private ConsumerRepository consumerRepository;
    private Consumer consumer;

    @BeforeEach
    void init() {
        consumerRepository = mock(ConsumerRepository.class);
        consumerService = new ConsumerServiceImpl(consumerRepository);
        consumer = new Consumer();
    }


    @Test
    void findAll() {
        List<Consumer> consumerList = new ArrayList<>();
        when(consumerRepository.findAll()).thenReturn(consumerList);

        assertNotNull(consumerRepository.findAll());

        verify(consumerRepository, times(1)).findAll();
    }

    @Test
    void findById() {
        int id = any(Integer.class);
        when(consumerRepository.findById(id)).thenReturn(Optional.ofNullable(consumer));

        assertNotNull(consumerService.findById(id));

        verify(consumerRepository, times(1)).findById(id);
    }

    @Test
    void addConsumer() {
        when(consumerRepository.save(consumer)).thenReturn(consumer);

        assertNotNull(consumerService.addConsumer(consumer));

        verify(consumerRepository, times(1)).save(consumer);
    }

    @Test
    void updateConsumer() {
        when(consumerRepository.findById(consumer.getIdConsumer())).thenReturn(Optional.ofNullable(consumer));
        when(consumerRepository.save(consumer)).thenReturn(consumer);

        assertNotNull(consumerService.updateConsumer(consumer.getIdConsumer(), consumer));

        verify(consumerRepository, times(1)).findById(consumer.getIdConsumer());
        verify(consumerRepository, times(1)).save(consumer);
    }

    @Test
    void updateConsumerNull() {
        when(consumerRepository.findById(consumer.getIdConsumer())).thenReturn(null);

        assertNull(consumerService.updateConsumer(consumer.getIdConsumer(), consumer));

        verify(consumerRepository, times(1)).findById(consumer.getIdConsumer());
        verify(consumerRepository, times(0)).save(consumer);
    }

    @Test
    void delete() {
        int id = any(Integer.class);
        consumerService.delete(id);

        verify(consumerRepository, times(1)).deleteById(id);
    }

    @Test
    void findByName() {
        String str = any(String.class);
        List<Consumer> consumerList = new ArrayList<>();
        when(consumerRepository.findByName(str)).thenReturn(consumerList);

        assertNotNull(consumerService.findByName(any(String.class)));

        verify(consumerRepository, times(1)).findByName(str);

    }
}