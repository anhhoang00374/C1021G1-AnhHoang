package test.model;

public class Teacher extends Person{
    private String level;

    public Teacher() {
    }

    public Teacher(String id, String name, String dayOfBirth, String gender,String level) {
        super(id, name, dayOfBirth, gender);
        this.level = level;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                super.toString()+
                ",level='" + level + '\'' +
                '}';
    }
}
