package model;

public class Product {
    private int id_product;
    private String name;
    private int price;
    private int quantity;
    private String description;
    private String color;
    private int category_id;
    private String category_name;

    public Product() {
    }

    public Product(int id_product, String name, int price, int quantity,
                   String description, String color, int category_id, String category_name) {
        this.id_product = id_product;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.color = color;
        this.category_id = category_id;
        this.category_name = category_name;
    }

    public Product(String name, int price, int quantity, String description, String color, int category_id, String category_name) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.color = color;
        this.category_id = category_id;
        this.category_name = category_name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }
}
