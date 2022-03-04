package code_gym.dsa_danh_sach.exercise.linked_list;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList <Node> listStudent = new LinkedList<>();
        Student student1 = new Student(1,"Hoang",25);
        Student student2 = new Student(2,"Hang",25);
        Student student3 = new Student(3,"Linh",25);
        Student student4 = new Student(4,"Dung",25);
        Student student5 = new Student(5,"Dat",25);
        Student student6 = new Student(6,"Hoa",25);
        listStudent.addLast(student5);
        listStudent.addLast(student1);
        listStudent.addLast(student3);
        listStudent.addFirst(student2);
        listStudent.add(4,student6);
        listStudent.remove(2);
        System.out.println(listStudent.get(3));
    }
}
