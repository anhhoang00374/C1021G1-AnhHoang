package code_gym.behavior.Observer;

abstract class Observer {
    protected Subject subject;
    public abstract void update();
}
