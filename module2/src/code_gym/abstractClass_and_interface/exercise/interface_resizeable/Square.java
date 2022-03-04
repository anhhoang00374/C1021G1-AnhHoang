package code_gym.abstractClass_and_interface.exercise.interface_resizeable;

public class Square implements Resizeable{
    private double width;

    public Square(){

    }

    public Square(double width){
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public void resize(double percent) {
        this.setWidth(this.getWidth()*percent);
    }
}
