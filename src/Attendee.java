public class Attendee {
    private String name;
    private char gender;
    private String email;
    private int age;
    private String seatNo;

    public Attendee(String name, char gender, String email, int age, String seatNo) {
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.age = age;
        this.seatNo = seatNo;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
    this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    @Override
    public String toString() {
        return "Attendee{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", seatNo='" + seatNo + '\'' +
                '}';
    }
}

