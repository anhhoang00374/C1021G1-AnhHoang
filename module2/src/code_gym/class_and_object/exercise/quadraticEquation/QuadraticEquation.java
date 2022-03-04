package code_gym.class_and_object.exercise.quadraticEquation;

public class QuadraticEquation {
    private double a;
    private double b;
    private  double c;
    public QuadraticEquation(double a, double b, double c ){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getDiscriminant(){
        return Math.pow(b,2)-4*this.c*this.a;
    }

    public double getRoot1(){
        return (-this.b+Math.sqrt(this.getDiscriminant()))/2*a;
    }

    public double getRoot2(){
        return (-this.b-Math.sqrt(this.getDiscriminant()))/2*a;
    }
}
