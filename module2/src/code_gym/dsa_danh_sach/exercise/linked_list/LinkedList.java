package code_gym.dsa_danh_sach.exercise.linked_list;

import java.util.Arrays;

public class LinkedList<E> {
    private Node head;
    private int numNodes = 0;
    public LinkedList(){
        this.head = null;
    }
    public void addLast(Student student){
       Node node = new Node(student);

        if(this.size()==0){
            node.next = this.head;
            this.head = node;
            numNodes++;
        }else{
            Node temp = head;
            Node holder;
            for(int i = 0;i<this.size()-1;i++){
                temp = temp.next;
            }
            holder = temp.next;
            temp.next = node;
            node.next = holder;
            numNodes++;
        }

    }

    public void addFirst(Student student){
        Node node = new Node(student);
        node.next = this.head;
        this.head = node;
        numNodes++;
    }

    public void add(int index, Student student){
        Node node = new Node(student);
        Node temp = head;
        Node holder;
        for(int i = 0;i<index-1;i++){
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = node;
        node.next = holder;
        numNodes++;
    }
    public int size(){
        return this.numNodes;
    }

    public void remove(int index){
        Node temp = head;
        Node holder;
        for(int i = 0;i<index-1;i++){
            temp = temp.next;
        }
        holder = temp.next.next;
        temp.next = holder;
        numNodes--;
    }

    public Student get(int index){
        Node temp = head;
        for(int i = 0;i<index;i++){
            temp = temp.next;
        }
        return (Student) temp.getData();
    }

    public Student getFirst(){
        if(head!=null){
            Node temp = head;
            return (Student) temp.getData();
        }
        return  null;
    }

    public  Student getLast(){
        if(head!=null){
            Node temp = head;
            for(int i = 0;i<numNodes-1;i++){
                temp = temp.next;
            }
            return (Student) temp.getData();
        }
        return null;

    }
    public LinkedList<Node> clone(LinkedList<Node> list){
        LinkedList<Node> listStudent = new LinkedList<>();
        for(int i = 0;i< list.size();i++){
            Student student = list.get(i);
            listStudent.addLast(student);
        }
        return listStudent;
    }

    public boolean contains(String name){
        Node temp = head;
        for(int i = 0;i<this.size();i++){
            Student student =(Student) temp.getData();
            if(student.getName()==name){
                return true;
            }
            temp = temp.next;

        }
        return false;
    }

    public int indexOf(String name){
        Node temp = head;
        for(int i = 0;i<this.size();i++){
            Student student =(Student) temp.getData();
            if(student.getName()==name){
                return i;
            }
            temp = temp.next;

        }
        return -1;
    }

    public void clear(){
        this.head = null;
    }

    public void printList(){
        Node currentNode = head;
        while (currentNode!=null){
        //Student student = (Student) currentNode.getData();
            currentNode.prinData();
            currentNode = currentNode.next;
        }
    }
}
