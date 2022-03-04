package test.model;

public abstract class Person {
    private String id;
    private String name;
    private String dayOfBirth;
    private String gender;

    public Person(){

    }

    public Person(String id, String name, String dayOfBirth, String gender) {
        this.id = id;
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", dayOfBirth='" + dayOfBirth + '\'' +
                ", gender='" + gender;
    }
}
