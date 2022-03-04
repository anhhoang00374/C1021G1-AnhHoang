package code_gym.inherictance.practice.shape.test_shape;

import code_gym.inherictance.practice.shape.shape.Shape;

public class ShapeTest {
    public static void main(String[] args) {
        Shape shape = new Shape();
        System.out.println(shape);

        shape = new Shape("red", false);
        System.out.println(shape);
    }
}
