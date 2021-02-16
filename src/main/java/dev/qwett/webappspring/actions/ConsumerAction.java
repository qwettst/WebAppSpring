package dev.qwett.webappspring.actions;

import com.opensymphony.xwork2.ActionSupport;
import dev.qwett.webappspring.entities.Consumer;
import dev.qwett.webappspring.services.ConsumerService;

import java.util.List;

public class ConsumerAction extends ActionSupport {

    private final ConsumerService consumerService;
    private List<Consumer> consumerList;
    private Consumer consumer;
    private int idConsumer;
    private String consumerName;

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

    public String delete() {
        consumerService.delete(idConsumer);
        return SUCCESS;
    }

    public String edit() {
        consumerService.updateConsumer(idConsumer, consumer);
        return SUCCESS;
    }

    public String getByName() {
        if (consumerName != null && !consumerName.trim().isEmpty()) {
            setConsumerList(consumerService.findByName(consumerName));
            return SUCCESS;
        }
        addActionError("Field address is empty");
        return ERROR;
    }

    public String getById() {
        consumer = consumerService.findById(idConsumer);
        return SUCCESS;
    }

    public void validate() {
        if (consumer != null) {
            if (consumer.getFirstName().length() == 0) {
                addFieldError("consumer.firstName", "das");
            }

            if (consumer.getLastName().length() == 0) {
                addFieldError("consumer.lastName", "Требуется ввести Фамилию");
            }

            if (consumer.getPhone().length() == 0) {
                addFieldError("consumer.phone", "Требуестся ввести номер телефона");
            }
        }
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

    public int getIdConsumer() {
        return idConsumer;
    }

    public void setIdConsumer(int idConsumer) {
        this.idConsumer = idConsumer;
    }

    public String getConsumerName() {
        return consumerName;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }
}
