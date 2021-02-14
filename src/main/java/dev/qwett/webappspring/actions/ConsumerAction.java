package dev.qwett.webappspring.actions;

import com.opensymphony.xwork2.ActionSupport;
import dev.qwett.webappspring.entities.Consumer;
import dev.qwett.webappspring.services.ConsumerService;

import java.util.List;

public class ConsumerAction extends ActionSupport {

    private final ConsumerService consumerService;
    private List<Consumer> consumerList;
    private Consumer consumer;

    public ConsumerAction(ConsumerService consumerService) {
        this.consumerService = consumerService;
    }

    public String execute() {
        setConsumerList(consumerService.findAll());
        return SUCCESS;
    }

    public String add() {
        consumerService.addConsumer(consumer);
        return SUCCESS;
    }

    public List<Consumer> getConsumerList() {
        return consumerList;
    }

    public void setConsumerList(List<Consumer> consumerList) {
        this.consumerList = consumerList;
    }

    public Consumer getConsumer() {
        return consumer;
    }

    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }

    public ConsumerService getConsumerService() {
        return consumerService;
    }
}
