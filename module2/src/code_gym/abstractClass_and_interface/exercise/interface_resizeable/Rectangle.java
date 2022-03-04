package code_gym.abstractClass_and_interface.exercise.interface_resizeable;

public class Rectangle implements Resizeable{
    private double width;
    private double height;

    public Rectangle(){

    }

    public Rectangle(double width,double height){
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

    @Override
    public void resize(double percent) {
        this.setHeight(this.getHeight()*percent);
        this.setWidth(this.getWidth()*percent);
    }
}
