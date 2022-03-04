package code_gym.abstractClass_and_interface.exercise.interface_resizeable;

public class Circle implements Resizeable{
    private double radius;

    public  Circle(){

    }

    public Circle(double radius){
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public void resize(double percent) {
        this.setRadius(this.getRadius()*percent);
    }
}
