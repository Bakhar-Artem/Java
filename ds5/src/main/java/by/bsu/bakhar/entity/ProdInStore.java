package by.bsu.bakhar.entity;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.Objects;

@XmlRootElement(name = "prod_in_store")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProdInStore implements Serializable {
    private static final long serialVersionUID = 1L;
    @XmlElement(name = "product")
    private Product product;
    @XmlElement(name = "store")
    private Store store;
    @XmlElement(name = "amount")
    private Integer amount;

    public ProdInStore() {
    }

    public ProdInStore(Product product, Store store, Integer amount) {
        this.product = product;
        this.store = store;
        this.amount = amount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("name: ").append(product.getName()).append(", city: ").append(store.getCity())
                .append(",amount: ").append(amount);
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProdInStore that = (ProdInStore) o;
        return product.equals(that.product) && store.equals(that.store) && amount.equals(that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, store, amount);
    }
}
