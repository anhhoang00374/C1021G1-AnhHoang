package code_gym.abstractClass_and_interface.exercise.interface_colorable;

public class Test {
    public static void main(String[] args) {
        Geometric[] arrGeometric = new Geometric[2];
        Rectangle rectangle = new Rectangle(4,5);
        Square square = new Square(4);
        arrGeometric[0] = rectangle;
        arrGeometric[1] = square;

        for(Geometric geometric: arrGeometric){
            System.out.println(geometric.getArea());
            if(geometric instanceof Colorable){
                ((Colorable) geometric).howToColor();
            }
        }
    }
}
