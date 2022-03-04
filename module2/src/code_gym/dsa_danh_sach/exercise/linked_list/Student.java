package code_gym.dsa_danh_sach.exercise.linked_list;

public class Student {
    private int id;
    private String name;
    private int age;

    public Student(int id, String name, int age){
        this.age = age;
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void printData(){
        System.out.println(this.getId() + " "+ this.getAge()+" "+ this.getName());
    }
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
