package code_gym.io_binary_file_serialization.exercise.model;

import java.io.Serializable;

public class Product  implements Serializable {
    private String codeProduct;
    private String nameProduct;
    private String producer;
    private int price;

    public Product(){

    }

    public Product(String codeProduct,String nameProduct, String producer,int price){
        this.codeProduct = codeProduct;
        this.nameProduct = nameProduct;
        this.producer = producer;
        this.price = price;
    }

    public String getCodeProduct() {
        return codeProduct;
    }

    public void setCodeProduct(String codeProduct) {
        this.codeProduct = codeProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "codeProduct='" + codeProduct + '\'' +
                ", nameProduct='" + nameProduct + '\'' +
                ", producer='" + producer + '\'' +
                ", price=" + price +
                '}';
    }
}
