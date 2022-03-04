package code_gym.abstractClass_and_interface.exercise.interface_colorable;

public class Geometric {
    private int width;
    public Geometric(){

    }

    public Geometric(int width){
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getArea(){
        return this.width*this.width;
    }
}
