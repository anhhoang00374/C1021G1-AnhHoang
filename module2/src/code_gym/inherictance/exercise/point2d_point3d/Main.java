package code_gym.inherictance.exercise.point2d_point3d;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Point2D point2D = new Point2D(2,3);
        Point3D point3D = new Point3D(2,3,4);
        System.out.println(point2D);
        System.out.println(point3D);
        float[] arr2D = Arrays.copyOf(point2D.getXY(),2);
        float[] arr3D = Arrays.copyOf(point3D.getXYZ(),3);
        System.out.println("arr2D");
        for(float fl : arr2D){
            System.out.print(fl+" ");
        }
        System.out.println();
        System.out.println("arr3D");
        for(float fl : arr3D){
            System.out.print(fl+" ");
        }
    }
}
