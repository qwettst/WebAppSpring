package dev.qwett.webappspring.Service.Store;

import dev.qwett.webappspring.Entity.Consumer;
import dev.qwett.webappspring.Repository.ConsumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumerService {
    private final ConsumerRepository consumerRepository;

    @Autowired
    public ConsumerService(ConsumerRepository consumerRepository) {
        this.consumerRepository = consumerRepository;
    }


    public List<Consumer> findAll() {
        return consumerRepository.findAll();
    }

    public Consumer findById(int id) {
        return consumerRepository.findById(id).orElse(null);
    }

    public Consumer addStore(Consumer consumer) {
        if (consumerRepository.findById(consumer.getIdConsumer()).orElse(null) == null)
            return consumerRepository.save(consumer);
        return null;
    }

    public Consumer updateStore(int id, Consumer consumer) {
        consumer.setIdConsumer(id);
        if (consumerRepository.findById(consumer.getIdConsumer()).orElse(null) != null)
            return consumerRepository.save(consumer);
        return null;
    }

    public void delete(int id) {
        consumerRepository.deleteById(id);
    }

    public List<Consumer> filterByName(String name){
        return consumerRepository.findByName(name);
    }
}
