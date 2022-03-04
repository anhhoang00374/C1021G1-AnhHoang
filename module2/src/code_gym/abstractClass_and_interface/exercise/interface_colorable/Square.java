package code_gym.abstractClass_and_interface.exercise.interface_colorable;

public class Square extends Geometric implements Colorable{
    public Square(){

    }

    public Square(int width){
        super(width);
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides");
    }
}
