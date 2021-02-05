package dev.qwett.webappspring.Service.Store;

import dev.qwett.webappspring.entity.Consumer;
import dev.qwett.webappspring.repository.ConsumerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class ConsumerServiceImpl implements ConsumerService {

    private final ConsumerRepository consumerRepository;

    public ConsumerServiceImpl(ConsumerRepository consumerRepository) {
        this.consumerRepository = consumerRepository;
    }


    public List<Consumer> findAll() {
        return consumerRepository.findAll();
    }

    public Consumer findById(int id) {
        return consumerRepository.findById(id).orElse(null);
    }

    public Consumer addConsumer(Consumer consumer) {
        if (consumerRepository.findById(consumer.getIdConsumer()).orElse(null) == null)
            return consumerRepository.save(consumer);
        return null;
    }

    public Consumer updateConsumer(int id, Consumer consumer) {
        consumer.setIdConsumer(id);
        if (consumerRepository.findById(consumer.getIdConsumer()).orElse(null) != null)
            return consumerRepository.save(consumer);
        return null;
    }

    public void delete(int id) {
        consumerRepository.deleteById(id);
    }

    public List<Consumer> findByName(String name) {
        return consumerRepository.findByName(name);
    }
}
