package code_gym.class_and_object.exercise.stop_watch;

public class Stopwatch {
    private long startTime;
    private long endTime;

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public static void main(String[] args) {
        Stopwatch stopwatch = new Stopwatch();
        stopwatch.startTime();
        System.out.println(stopwatch.getStartTime());
        for(int i = 0;i<1000000;i++){
        }
        stopwatch.stop();
        System.out.println(stopwatch.getEndTime());
        System.out.println(stopwatch.getElapsedTime());
    }
    void startTime(){
        this.startTime = System.currentTimeMillis();
    }

     void stop(){
            this.endTime = System.currentTimeMillis();
    }
     long getElapsedTime(){
        return this.endTime-this.startTime;
    }
}
