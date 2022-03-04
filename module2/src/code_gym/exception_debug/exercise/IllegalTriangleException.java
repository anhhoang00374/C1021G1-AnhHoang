package code_gym.exception_debug.exercise;

public class IllegalTriangleException extends Exception{
    private String err;
    public IllegalTriangleException (String err){
        this.err = err;
    }

    public String getErr() {
        return err;
    }

    public void setErr(String err) {
        this.err = err;
    }
}
