package code_gym._demo;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends  Student{
    public Teacher(String name, int age) {
        super(name, age);
    }
   static List<Student> listS = new ArrayList<>();

    public static void main(String[] args) {
        Teacher teacher = new Teacher("sad",12);
        listS.add(teacher);
        add(3);
    }
    static void add(int ele){
        System.out.println(ele);

    }}
