package code_gym.abstractClass_and_interface.exercise.interface_resizeable;

public class ResizeableTest {
    public static void main(String[] args) {
        Circle circle = new Circle(3);
        Rectangle rectangle = new Rectangle(4,5);
        Square square = new Square(4);

        System.out.println("trước khi resize");
        System.out.println("circle");
        System.out.println(circle.getRadius());
        System.out.println("rectangle");
        System.out.println(" height:"+rectangle.getHeight()+ " width:"+rectangle.getWidth());
        System.out.println("square");
        System.out.println(square.getWidth());
        circle.resize(2);
        rectangle.resize(2);
        square.resize(2);
        System.out.println("sau khi resize");
        System.out.println("circle");
        System.out.println(circle.getRadius());
        System.out.println("rectangle");
        System.out.println(" height:"+rectangle.getHeight()+ " width:"+rectangle.getWidth());
        System.out.println("square");
        System.out.println(square.getWidth());
    }
}
