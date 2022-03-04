package code_gym.class_and_object.practice.rectangle;

public class Rectangle {
    private double width;
    private double height;
    public Rectangle(){

    }
    public Rectangle(double width, double height){
        this.height = height;
        this.width = width;
    }

    public double getArea(){
        return this.width*this.height;
    }

    public double getPerimeter() {
        return (this.width + this.height) * 2;
    }

    public String display (){
        return "Rectangle{" + "width=" + width + ", height=" + height + "}";
    }
}
