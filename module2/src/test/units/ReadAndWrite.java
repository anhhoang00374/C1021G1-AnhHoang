package test.units;

import test.model.Person;
import test.model.Student;
import test.model.Teacher;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWrite {
    public static void write(String path, List<Person> list){
        try {
            FileWriter fileWriter = new FileWriter(path);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for(Person person : list){
                if(person instanceof Student){
                    //String id, String name, String dayOfBirth, String gender, String grade, int score
                    bufferedWriter.write(person.getId()+","+person.getName()+","+person.getDayOfBirth()+","+
                            person.getGender()+","+((Student) person).getGrade()+","+((Student)person).getScore());
                    bufferedWriter.newLine();
                }else{
                    bufferedWriter.write(person.getId()+","+person.getName()+","+person.getDayOfBirth()+","+
                            person.getGender()+","+((Teacher) person).getLevel());
                    bufferedWriter.newLine();
                }
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static List<Person> read(String path){
        List<Person> personList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String data = null;
            while((data = bufferedReader.readLine())!=null){
                String[] personArray = data.split(",");
                if(data.length() == 6){
                    Student student = new Student(personArray[0],personArray[1],personArray[2],
                            personArray[3],personArray[4],Integer.parseInt(personArray[5]));
                    personList.add(student);
                }else{
                    Teacher teacher = new Teacher(personArray[0],personArray[1],personArray[2],
                            personArray[3],personArray[4]);
                    personList.add(teacher);
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return personList;

    }
}
