package code_gym.dsa_danh_sach.exercise.linked_list;

public class Node {
    public Node next;
    private Object data;

    public  Node(Student data){
        this.data=data;
        this.next = null;
    }
    public Object getData(){
        return this.data;
    }
    public void prinData(){
        if(data instanceof Student){
            Student student = (Student) data;
            //data = (Student) data;
            student.printData();
        }

    }
}
