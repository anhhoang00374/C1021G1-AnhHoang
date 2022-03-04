package code_gym.class_and_object.exercise.fan;

public class Fan {
    private final int  SLOW = 1;
    private final int MEDIUM = 2;
    private final int FAST = 3;
    private int speed = this.SLOW;
    private boolean on = false;
    private double radius = 5d;
    private String color = "blue";

    public Fan(){}

    public int getSLOW() {
        return SLOW;
    }

    public int getMEDIUM() {
        return MEDIUM;
    }

    public int getFAST() {
        return FAST;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        if(this.isOn()){
            return
                    "speed=" + speed +
                            ", radius=" + radius +
                            ", color='" + color + " fan is on"
                    ;
        }else {
            return " radius=" + radius +
                            ", color='" + color + " fan is off"
                    ;
        }

    }

    public static void main(String[] args) {
        Fan fan = new Fan();
        Fan fan2 = new Fan();
        fan.setSpeed(fan.getFAST());
        fan.setRadius(10);
        fan.setColor("yellow");
        fan.setOn(true);
        fan2.setSpeed(fan.getMEDIUM());
        fan2.setRadius(5);
        System.out.println(fan);
        System.out.println(fan2);
    }
}
