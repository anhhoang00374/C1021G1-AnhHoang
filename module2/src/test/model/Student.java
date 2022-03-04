package test.model;

public class Student extends Person{
    private String grade;
    private int score;

    public Student() {
    }

    public Student(String id, String name, String dayOfBirth, String gender, String grade, int score) {
        super(id, name, dayOfBirth, gender);
        this.grade = grade;
        this.score = score;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                super.toString()+
                ",grade='" + grade + '\'' +
                ", score=" + score +
                '}';
    }
}
