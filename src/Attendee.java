public class Attendee {
    
    private String name;
    private char gender;
    private String email;
    private int age;

    public Attendee(String name, char gender, String email, int age) {
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.age = age;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public char getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + ", Gender: " + this.gender +
               ", Email: " + this.email + ", Age: " + this.age;
    }
}