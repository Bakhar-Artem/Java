package by.bsu.bakhar.entity;

public class Product {
    private int id;
    private String name;

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

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("name: ").append(name);
        return stringBuilder.toString();
    }
}
