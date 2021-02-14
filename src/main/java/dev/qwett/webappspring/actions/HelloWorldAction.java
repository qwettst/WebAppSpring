package dev.qwett.webappspring.actions;

import com.opensymphony.xwork2.ActionSupport;
import dev.qwett.webappspring.entities.model.MessageStore;
import dev.qwett.webappspring.services.StoreService;
import org.springframework.beans.factory.annotation.Qualifier;


public class HelloWorldAction extends ActionSupport {

    private final StoreService storeService;
    private MessageStore messageStore;

    public HelloWorldAction(@Qualifier("storeServiceImpl") StoreService storeService) {
        this.storeService = storeService;
    }

    public String execute() {
        storeService.findAll();
        messageStore = new MessageStore();
        return SUCCESS;
    }

    public MessageStore getMessageStore() {
        return messageStore;
    }
}