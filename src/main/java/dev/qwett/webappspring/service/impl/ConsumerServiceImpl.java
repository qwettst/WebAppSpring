package dev.qwett.webappspring.service.impl;

import dev.qwett.webappspring.entities.Consumer;
import dev.qwett.webappspring.service.ConsumerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
class ConsumerServiceImpl implements ConsumerService {

    private static final Logger logger = LoggerFactory.getLogger(ConsumerService.class);

    private final ConsumerRepository consumerRepository;

    private EntityManager em;

    @PersistenceContext
    public void setEm(EntityManager em) {
        this.em = em;
    }

    ConsumerServiceImpl(ConsumerRepository consumerRepository) {
        this.consumerRepository = consumerRepository;
    }

    public List<Consumer> findAll() {
        logger.info("Search all records in database");
        return consumerRepository.findAll();
    }

//    public Consumer findById(int id) {
//        logger.info("Find Consumers with id = {}", id);
//        return consumerRepository.findById(id).orElse(null);
//    }

//    public Consumer addConsumer(Consumer consumer) {
//        logger.info("Add Consumer...");
//        if (!consumerRepository.findById(consumer.getIdConsumer()).isPresent()) {
//            Consumer resConsumer = consumerRepository.save(consumer);
//            logger.info("Consumer with id = {} , was added", resConsumer.getIdConsumer());
//            return resConsumer;
//        }
//        logger.warn("Adding error occurred when adding a Consumer");
//        return null;
//    }

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

    @Transactional
    public Consumer addConsumer(Consumer consumer) {
        logger.info("Add Consumer...");
        if (findById(consumer.getIdConsumer()) == null) {
            em.persist(consumer);
            em.flush();
            logger.info("Consumer with id = {} , was added", consumer.getIdConsumer());
            return consumer;
        }
        logger.warn("Adding error occurred when adding a Consumer");
        return null;
    }

    public Consumer findById(int id) {
        TypedQuery<Consumer> query = em.createQuery("SELECT consumer FROM Consumer consumer where consumer.idConsumer = :id", Consumer.class);
        query.setParameter("id", id);
        logger.info("Find Consumers with id = {}", id);
        return query.getResultList().stream().findAny().orElse(null);
    }

    public List<Consumer> searchFilter(String name, String lastName, String phone) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Consumer> cq = cb.createQuery(Consumer.class);
        Root<Consumer> root = cq.from(Consumer.class);

        Predicate likeFirstName = cb.like(root.get("firstName"), "%" + name + "%");
        Predicate likeLastName = cb.like(root.get("lastName"), "%" + lastName + "%");
        Predicate andFirstLastName = cb.and(likeFirstName, likeLastName);

        Predicate likePhone = cb.like(root.get("phone"), "%" + phone + "%");
        Predicate orPhoneNameAnd = cb.and(likePhone, andFirstLastName);

        if (phone.trim().isEmpty()) {
            cq.select(root).
                    where(andFirstLastName);
        } else {
            cq.select(root).
                    where(orPhoneNameAnd);
        }
//        cq.select(root).
//                where(cb.and(
//                        cb.like(root.get("firstName"), "%" + name + "%"),
//                        cb.like(root.get("lastName"), "%" + lastName + "%")));
        logger.info("Search for entries, where firstName = {} lastName = {} phone = {}", name, lastName, phone);
        return em.createQuery(cq).getResultList();
    }
}
