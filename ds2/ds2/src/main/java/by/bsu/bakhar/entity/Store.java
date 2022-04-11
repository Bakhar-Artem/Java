package by.bsu.bakhar.entity;

public class Store {
    private Integer storeId;
    private String city;

    public Store(Integer storeId, String city) {
        this.storeId = storeId;
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
}
