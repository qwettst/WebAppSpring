package dev.qwett.webappspring.actions;

import com.opensymphony.xwork2.ActionSupport;
import dev.qwett.webappspring.entities.Store;
import dev.qwett.webappspring.services.StoreService;

import java.util.List;


public class StoreAction extends ActionSupport {

    private final StoreService storeService;
    private List<Store> storeList;
    private Store store;

    public StoreAction(StoreService storeService) {
        this.storeService = storeService;
    }

    public String execute() {
        setStoreList(storeService.findAll());
        return SUCCESS;
    }

    public String add() {
        storeService.addStore(store);
        return SUCCESS;
    }

    public List<Store> getStoreList() {
        return storeList;
    }

    public void setStoreList(List<Store> storeList) {
        this.storeList = storeList;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
}
