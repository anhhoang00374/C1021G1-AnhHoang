package code_gym.dsa_danh_sach.practice.simple_list;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object element[];
    public MyList(){
        element = new Object[DEFAULT_CAPACITY];
    }

    private void ensureCapa(){
        int newSize = element.length*2;
        element = Arrays.copyOf(element,newSize);
    }

    public void add(E e){
        if(size == element.length){
            ensureCapa();
        }
        element[size++] = e;
    }

    public E  get(int index){
        if(index>size-1||index<0){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index );
        }
        return (E) element[index];
    }
}
