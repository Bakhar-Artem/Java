package by.bsu.bakhar.entity;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.Objects;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Store implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer storeId;
    private String city;

    public Store() {
    }

    public Store(Integer storeId, String city) {
        this.storeId = storeId;
        this.city = city;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("id: ").append(storeId);
        stringBuilder.append(", city: ").append(city);
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Store store = (Store) o;
        return storeId.equals(store.storeId) && city.equals(store.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(storeId, city);
    }
}
