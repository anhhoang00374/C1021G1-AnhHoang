package code_gym.access_modifier_static.exercise.access_modifier2;

public class Student {
    private String name = "John";
    private String classes = "C02";
    public Student(){

    }

    protected void setClasses(String classes) {
        this.classes = classes;
    }

    private void setName(String name) {
        this.name = name;
    }
}
