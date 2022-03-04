package code_gym.inherictance.practice.shape.shape;

public class Circle extends Shape{
    private double radius = 1.0d;

    public Circle(){
        super();
    }

    public Circle(double radius){
        this.radius = radius;
    }

    public Circle(String color,boolean filled,double radius){
        super(color,filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea(){
        return this.radius*this.radius*Math.PI;
    }

    public double getPerimeter(){
        return  this.radius*2*Math.PI;
    }

    @Override
    public String toString() {
        return "A circle with radius = " +
                +this.getRadius()+super.toString();
    }
}
