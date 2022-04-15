package by.bsu.bakhar.entity;

import java.io.Serializable;

public class ProdInStore implements Serializable {
    private static final long serialVersionUID = 1L;
    private Product product;
    private Store store;
    private Integer amount;

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
}
