package code_gym.inherictance.practice.shape.test_shape;

import code_gym.inherictance.practice.shape.shape.Circle;

public class CircleTest {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle);

        circle = new Circle(3.5);
        System.out.println(circle);

        circle = new Circle( "indigo", false,3.5);
        System.out.println(circle);
    }
}
