package test.codegymService;

import test.model.Person;
import test.model.Student;
import test.model.Teacher;
import test.units.ReadAndWrite;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonService implements ICodegymService{
    public static final String EMPLOYEE = "/Users/nguyenhoang/Desktop/codegym/C1021G1/module2/src/test/data/codegymEmployee.csv";
    static Scanner scanner;
    List<Person> personList ;
    public PersonService(){
        personList = ReadAndWrite.read(EMPLOYEE);
    }
    @Override
    public void add(int num) {
        scanner = new Scanner(System.in);
        if(num==1){
            //String id, String name, String dayOfBirth, String gender, String grade, int score
            addStudent();
            ReadAndWrite.write(EMPLOYEE,personList);
        }else {
            addTeacher();
            ReadAndWrite.write(EMPLOYEE,personList);
        }
    }

    private void addTeacher() {

        String id = randomId("TC");
        String dayOfBirth;
        String gender;
        String name;
        String level;
        System.out.println("Vui lòng nhập tên");
        name = scanner.nextLine();

        System.out.println("vui lòng nhập ngày sinh");
        dayOfBirth = scanner.nextLine();

        do{
            System.out.println("vui lòng nhập giới tính(nam/nu)");
            gender = scanner.nextLine();
            if(!gender.equals("nam")&&!gender.equals("nu")){
                System.out.println("vui lòng nhập giới tính(nam/nu)");
                continue;
            }
            break;
        }while ((true));

        System.out.println("level");
        level = scanner.nextLine();

        //String id, String name, String dayOfBirth, String gender,String level
        Teacher teacher  = new Teacher(id,name,dayOfBirth,gender,level);
        personList.add(teacher);
    }

    private void addStudent() {
        String id = randomId("ST");
        String dayOfBirth;
        String gender;
        int score;
        String name;
        String grade;
        System.out.println("Vui lòng nhập tên");
        name = scanner.nextLine();

        System.out.println("vui lòng nhập ngày sinh");
        dayOfBirth = scanner.nextLine();

        do{
            System.out.println("vui lòng nhập giới tính(nam/nu)");
            gender = scanner.nextLine();
            if(!gender.equals("nam")&&!gender.equals("nu")){
                System.out.println("vui lòng nhập giới tính(nam/nu)");
                continue;
            }
            break;
        }while ((true));


        System.out.println("vui lòng nhập lớp");
        grade = scanner.nextLine();

        do{
            System.out.println("vui lòng nhập điểm");

            try{
                score = Integer.parseInt(scanner.nextLine());
            }catch (Exception e){
                System.out.println("vui lòng so");
                continue;
            }
            if(score<0 || score>100){
                System.out.println("vui lòng số lớn hơn 0 và nhở hơn 100");
                continue;
            }
            break;
        }while (true);

        Student student  = new Student(id,name,dayOfBirth,gender,grade,score);
        personList.add(student);
    }

    @Override
    public void delete(int num) {
        scanner = new Scanner(System.in);
        String id  = null;
        boolean check = true;
        if(num == 1){
            for(Person person : personList){
                if(person instanceof Student){
                    System.out.println(person);
                }
            }

        }else if(num == 2){
            for(Person person : personList){
                if(person instanceof Teacher){
                    System.out.println(person);
                }
            }
        }
        do {
            check = true;
            System.out.println("vui lòng nhập vào Id muốn xoá");
            id = scanner.nextLine();
            int index = 0;
            for(int i = 0;i<personList.size();i++){
                if(personList.get(i).getId().toLowerCase().equals(id.toLowerCase())){
                    check = false;
                    index = i;
                    break;
                }
            }
            if(check){
                System.out.println("vui long nhap lai");

            }else {
                personList.remove(index);

            }
        }while(check);
        ReadAndWrite.write(EMPLOYEE,personList);

    }

    @Override
    public void search() {
        String name;
        scanner = new Scanner(System.in);
        System.out.println("innput name");
        name = scanner.nextLine();
        boolean check = false;
        for(Person person : personList){
            if(person.getName().toLowerCase().contains(name));
            System.out.println(person);
            check = true;
        }
        if(!check){
            System.out.println("data not exist");
        }
    }

    @Override
    public void display(int num) {
        if(num == 1){
            for(Person person: personList){
                if(person instanceof Student){
                    System.out.println(person);
                }
            }

        }else{
            for(Person person: personList){
                if(person instanceof Teacher){
                    System.out.println(person);
                }
            }
        }
    }

    int random(){
        return (int) Math.floor(Math.random()*10);
    }
    String randomId(String position){
        return position+random() + random() +random();
    }

}
