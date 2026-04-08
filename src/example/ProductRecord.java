package example;

public class ProductRecord {
    private final int id;
    private final String name;

    public ProductRecord(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}