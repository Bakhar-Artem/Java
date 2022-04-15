package by.bsu.bakhar.entity;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Objects;


public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;

    public Product() {
    }

    public Product(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("name: ").append(name);
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && name.equals(product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
