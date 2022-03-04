package code_gym.dsa_stack_queue.practice.stack_linkedList;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class MyGenericStack<T> {
    LinkedList<T> stack;
    public MyGenericStack(){
        stack = new LinkedList<T>();
    }

    public void push(T element){
        stack.addFirst(element);
    }

    public T pop(){
        if(stack.isEmpty()){
            throw new EmptyStackException();
        }
        return stack.removeFirst();
    }

    public int size(){
        return stack.size();
    }

    public boolean isEmpty(){
        if(stack.size()==0){
            return true;
        }
        return false;
    }
}
