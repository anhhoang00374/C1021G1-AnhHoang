package code_gym._demo;

import java.io.Serializable;
import java.util.Objects;

public class Student extends Demo implements Comparable<Student>, Serializable {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

//    @Override
//    public String toString() {
//        return "Student : " +
//                "name='" + name + '\'' +
//                ", age=" + age;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age);
    }

    @Override
    public int compareTo(Student o) {
        return this.getAge() - o.getAge();
    }
}
