package module2.utils;

public class NotFoundProductException extends Exception{
    public void displayException(){
        System.out.println("Sản phẩm không tồn tại");
    }
}
