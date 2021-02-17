package dev.qwett.webappspring.actions;

import com.opensymphony.xwork2.ActionSupport;
import dev.qwett.webappspring.entities.Store;
import dev.qwett.webappspring.services.StoreService;

import java.util.List;


public class StoreAction extends ActionSupport {

    private final StoreService storeService;
    private List<Store> storeList;
    private Store store;
    private int idStore;
    private String storeAddress;

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

    public String edit() {
        storeService.updateStore(idStore, store);
        return SUCCESS;
    }

    public String delete() {
        storeService.delete(idStore);
        return SUCCESS;
    }

    public String getByAddress() {
        setStoreList(storeService.findByAddress(storeAddress));
        return SUCCESS;
    }

    public String getById() {
        store = storeService.findById(idStore);
        return SUCCESS;
    }

    public void validate() {
        if (store != null) {
            if (store.getAddress().length() == 0) {
                addFieldError("store.address", "The Address is required");
            }
        }
    }

    public int getIdStore() {
        return idStore;
    }

    public void setIdStore(int idStore) {
        this.idStore = idStore;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
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
