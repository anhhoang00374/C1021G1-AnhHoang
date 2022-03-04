package code_gym.java_collection_framework.exercise.manager.model;

public class ProductManager {
    private static int id;
    private String name;
    private  int price;
    private int productId;

    public ProductManager(){

    }

    public ProductManager(String name,int price){
        id++;
        this.name = name;
        this.price = price;
        this.productId = id;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        ProductManager.id = id;
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

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "ProductManager : " +
                "name = " + name +
                ", price = " + price +
                ", productId = " + productId;
    }
}
