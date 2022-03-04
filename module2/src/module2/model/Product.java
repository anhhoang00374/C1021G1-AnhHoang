package module2.model;

public abstract class Product {
    private int id;
    static private int autoID = 0;
    private String productCode;
    private  String name;
    private int price;
    private int quantity;
    private String producer;

    public Product() {
    }

    public Product(String productCode, String name, int price, int quantity, String producer) {
        autoID++;
        this.id = autoID;
        this.productCode = productCode;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.producer = producer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getAutoID() {
        return autoID;
    }

    public static void setAutoID(int autoID) {
        Product.autoID = autoID;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
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

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", productCode='" + productCode + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", producer='" + producer;
    }

    //import
}
