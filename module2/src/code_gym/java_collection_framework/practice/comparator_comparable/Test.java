package code_gym.java_collection_framework.practice.comparator_comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Student student = new Student("Kien", 30, "HT");
        Student student1 = new Student("Nam", 26, "HN");
        Student student2 = new Student("Anh", 38, "HT" );
        Student student3 = new Student("Tung", 38, "HT" );

        List<Student> lists = new ArrayList<Student>();
        lists.add(student);
        lists.add(student1);
        lists.add(student2);
        lists.add(student3);

        System.out.println("sắp xếp theo tên");
        Collections.sort(lists);
        for(Student st : lists){
            System.out.println(st.toString());
        }


        Collections.sort(lists, new Comparator<Student>() {

            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge()-o2.getAge();
            }
        });
        System.out.println("sắp xếp theo tuổi");
        for(Student st : lists){
            System.out.println(st.toString());
        }
    }
}
