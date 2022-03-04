package code_gym.abstractClass_and_interface.exercise.interface_colorable;

public class Rectangle extends Geometric{
    private int height;
    public Rectangle(){

    }

    public Rectangle(int height,int width){
        super(width);
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int getArea() {
        return this.getHeight()*this.getWidth();
    }
}
