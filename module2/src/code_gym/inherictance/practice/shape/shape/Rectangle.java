package code_gym.inherictance.practice.shape.shape;

public class Rectangle extends Shape{
    private double width = 1.0d;
    private double height = 1.0d;

    public Rectangle(){

    }

    public Rectangle(double width, double height){
        this.width = width;
        this.height = height;
    }

    public Rectangle(String color,boolean filled,double width, double height){
        super(color,filled);
        this.height = height;
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getArea() {
        return this.width * this.height;
    }

    public double getPerimeter() {
        return 2 * (this.width + this.height);
    }

    @Override
    public String toString() {
        return "A Rectangle with width="
                + getWidth()
                + " and height="
                + getHeight()
                + ", which is a subclass of "
                + super.toString();
    }
}
