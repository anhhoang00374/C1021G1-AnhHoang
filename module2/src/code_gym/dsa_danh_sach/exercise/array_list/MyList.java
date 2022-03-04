package code_gym.dsa_danh_sach.exercise.array_list;

import java.util.Arrays;

public class MyList<E> {
    int size = 0;
    static final int DEFAULT_CAPACITY = 10;
    Object[] element;

    public MyList(){
    }
    public MyList(int capacity){
        element = new Object[capacity];
    }
    private void ensureCapa(){
        int newSize = element.length*2;
        element = Arrays.copyOf(element,newSize);
    }

    public void  add(E e){
        if(this.size==element.length){
            ensureCapa();
        }
        element[size] = e;
        size++;
    }

    public void add(int index,E e){
        if(this.size==element.length){
            ensureCapa();
        }
        for(int i = size;i>index;i--){
            element[i] = element[i-1];
        }
        element[index] = e;
        size++;
    }

    public void remove(int index){
        if(index == element.length-1){
            element[element.length-1] = null;
        }
        for(int i = index;i<element.length-1;i++){
            element[i] = element[i+1];
        }
        element[element.length-1] = null;
        size--;
    }

    public int size(){
        return  this.size;
    }

    public MyList<E> clone(){
        MyList<E> newArray = new MyList<E>(size);
        for(int i = 0;i<element.length;i++){
            newArray.add((E)element[i]);
        }
        return newArray;
    }

    public boolean contains(E e){
        for(int i = 0;i<element.length;i++){
            if(e == element[i]){
                return true;
            }
        }
        return false;
    }

    public int indexOf(E e){
        int index = -1;
        for(int i = 0;i<element.length;i++){
            if(element[i]==e){
                index = i;
                break;
            }
        }
        return index;
    }

    public Object get(int index){
            return element[index];
    }

    public void clear(){
        for(int i = 0;i<element.length;i++){
            element[i] = null;
        }
    }

    public void print(){
        for(Object value:element){
            if(value!=null){
                System.out.println(value);
            }

        }
    }


}
