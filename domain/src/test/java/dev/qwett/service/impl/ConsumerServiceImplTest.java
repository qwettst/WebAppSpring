package dev.qwett.service.impl;

import dev.qwett.entities.Consumer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ConsumerServiceImplTest {

    private ConsumerServiceImpl consumerService;
    private ConsumerRepository consumerRepository;
    private EntityManager entityManager;
    private TypedQuery query;
    private Consumer consumer;

    @BeforeEach
    void init() {
        consumerRepository = mock(ConsumerRepository.class);
        entityManager = mock(EntityManager.class);
        query = mock(TypedQuery.class);
        consumerService = new ConsumerServiceImpl(consumerRepository);
        consumer = new Consumer();
        consumer.setFirstName("Dsadasfas");
        consumerService.setEm(entityManager);
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
        when(consumerRepository.findById(consumer.getIdConsumer())).thenReturn(Optional.ofNullable(consumer));
        when(entityManager.createQuery(anyString(), any())).thenReturn(query);

        assertTrue((consumerRepository.findById(id)).isPresent());

        verify(consumerRepository, times(1)).findById(id);
    }

    @Test
    void saveConsumer() {
        when(consumerRepository.save(consumer)).thenReturn(consumer);

        assertNotNull(consumerService.saveConsumer(consumer));

        verify(consumerRepository, times(1)).save(consumer);
    }

    @Test
    void saveConsumerJPA() {
        when(entityManager.createQuery(anyString(), any())).thenReturn(query);
        when(query.setParameter(eq("id"), anyInt())).thenReturn(query);

        assertNotNull(consumerService.saveConsumerJPA(consumer));

        verify(entityManager, times(1)).persist(consumer);
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
        when(consumerRepository.findById(consumer.getIdConsumer())).thenReturn(Optional.empty());

        assertNull(consumerService.updateConsumer(consumer.getIdConsumer(), consumer));

        verify(consumerRepository, times(1)).findById(consumer.getIdConsumer());
        verify(consumerRepository, times(0)).save(consumer);
    }

    @Test
    void delete() {
        consumerService.delete(anyInt());

        verify(consumerRepository, times(1)).deleteById(anyInt());
    }

    @Test
    void findByName() {
        String str = any(String.class);
        List<Consumer> consumerList = new ArrayList<>();
        when(consumerRepository.findByName(str)).thenReturn(consumerList);

        assertNotNull(consumerService.findByName(str));

        verify(consumerRepository, times(1)).findByName(str);
    }
}