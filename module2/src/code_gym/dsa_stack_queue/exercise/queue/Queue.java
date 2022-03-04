package code_gym.dsa_stack_queue.exercise.queue;

public class Queue<T> {
    T[] queue;
    int rear;
    int front;
    int size;

    public Queue(int sizeOfArray){
        queue =(T[]) new Object[sizeOfArray];
        rear = -1;
        front = -1;
        size = 0;

    }

    public boolean isEmpty(){
        if(this.size == 0){
            return true;
        }
        return false;
    }

    public  void enqueue(T element){
        if(this.rear != queue.length-1){
            rear++;
            queue[rear] = element;
            size++;
        }
    }

    public T dequeue(){
        T response = null;
        if(size!=0){
            front++;
            response =(T) queue[front];
            size--;
        }
        return response;
    }
}
