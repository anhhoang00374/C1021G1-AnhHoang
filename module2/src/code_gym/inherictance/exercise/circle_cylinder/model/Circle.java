package code_gym.inherictance.exercise.circle_cylinder.model;

public class Circle {
    private String color;
    private double radius;
    private final double PI = Math.PI;

    public Circle(){

    }

    public Circle(String color,double radius){
        this.color = color;
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getPI() {
        return PI;
    }

    @Override
    public String toString() {
        return "Circle : " +
                "color = '" + color +
                ", radius = " + radius;
    }
}
