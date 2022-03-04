package code_gym.inherictance.exercise.point_moveablePoint;

public class MovablePoint extends Point{
    private float xSpeed = 0.0f;
    private  float ySpeed = 0.0f;

    public MovablePoint(){

    }

    public MovablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setSpeed(float xSpeed,float ySpeed){
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float[] getSpeed(){
        float[] arr = new float[2];
        arr[0] = this.xSpeed;
        arr[1] = this.ySpeed;
        return arr;
    }

    public void move(){
        this.setX(this.getX()+this.xSpeed);
        this.setY(this.getY()+this.ySpeed);
    }

    @Override
    public String toString() {
        return "MovablePoint " +
                "X = "+this.getX()+
                "Y = "+this.getY()+
                " xSpeed = " + xSpeed +
                ", ySpeed = " + ySpeed;
    }

}
