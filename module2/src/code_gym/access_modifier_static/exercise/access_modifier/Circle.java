package code_gym.access_modifier_static.exercise.access_modifier;

public class Circle {
    private double radius = 1.0d;
    private  String color = "red";

    public Circle(){

    }
    public Circle(double radius){
        this.radius = radius;
    }

    private double getRadius(){
        return this.radius;
    }

    protected   double getArea(){
        return this.radius*this.radius*Math.PI;
    }
}
