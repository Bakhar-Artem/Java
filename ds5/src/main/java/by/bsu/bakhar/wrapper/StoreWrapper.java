package by.bsu.bakhar.wrapper;

import by.bsu.bakhar.entity.Store;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "stores")
@XmlAccessorType(XmlAccessType.FIELD)
public class StoreWrapper {
    @XmlElement(name = "store")
    private List<Store> storeList;

    public List<Store> getStoreList() {
        return storeList;
    }

    public void setStoreList(List<Store> storeList) {
        this.storeList = storeList;
    }
}
