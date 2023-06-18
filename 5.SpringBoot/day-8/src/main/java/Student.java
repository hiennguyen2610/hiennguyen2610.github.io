import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder

public class Student {
    private int id;
    private String name;
    private LocalDate dob;
    private String hometown;
    private String address;
    private Double gpa;

    public Student(int id, String name, LocalDate dob, String hometown, String address, Double gpa) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.hometown = hometown;
        this.address = address;
        this.gpa = gpa;
    }

    public Student() {

    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public String getHometown() {
        return hometown;
    }

    public String getAddress() {
        return address;
    }

    public Double getGpa() {
        return gpa;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", hometown='" + hometown + '\'' +
                ", address='" + address + '\'' +
                ", gpa=" + gpa +
                '}';
    }
}

