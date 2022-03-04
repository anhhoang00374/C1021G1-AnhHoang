package code_gym.dsa_stack_queue.exercise.queue;

public class QueueTest {
    public static void main(String[] args) {
        Queue<String> queue = new Queue<>(10);
        queue.enqueue("Nguyen A");
        queue.enqueue("Nguyen B");
        queue.enqueue("Nguyen C");
        queue.enqueue("Nguyen D");
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
