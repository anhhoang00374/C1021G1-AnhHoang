package code_gym.inherictance.exercise.circle_cylinder.model;

public class Cylinder extends Circle{
    private  int height;
    public Cylinder(){

    }

    public  Cylinder(String color, double radius,int height){
        super(color,radius);
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "height=" + height +
                "color = '" + this.getColor() +
                ", radius = " + this.getRadius();
    }
}
