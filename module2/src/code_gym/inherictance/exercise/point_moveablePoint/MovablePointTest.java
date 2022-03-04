package code_gym.inherictance.exercise.point_moveablePoint;

public class MovablePointTest {
    public static void main(String[] args) {
        MovablePoint movablePoint = new MovablePoint(2,3,4,5);
        float[] arr =movablePoint.getXY();
        System.out.println("giá trị x và y");
        System.out.println(arr[0] + " "+arr[1]);
        System.out.println("trước khi tăng speed");
        System.out.println(movablePoint);
        System.out.println("sau khi tăng speed");
        movablePoint.move();
        System.out.println(movablePoint);
    }
}
