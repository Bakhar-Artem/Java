package by.bsu.bakhar.wrapper;

import by.bsu.bakhar.entity.ProdInStore;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "prodsInStores")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProdInStoreWrapper {
    @XmlElement(name = "prod_in_store")
    private List<ProdInStore> prodInStoreList;

    public List<ProdInStore> getProdInStoreList() {
        return prodInStoreList;
    }

    public void setProdInStoreList(List<ProdInStore> prodInStoreList) {
        this.prodInStoreList = prodInStoreList;
    }
}
