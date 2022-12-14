package encapsulation_demo;

public class Student {
    private String id;
    private double avgScore;
    private int age;
    private String className;

    public Student() {
    }

    public Student(String id, double avgScore, int age, String className) {
        this.id = id;
        this.avgScore = avgScore;
        this.age = age;
        this.className = className;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id.length() != 8) {
            System.out.println("Mã sinh viên phải có độ dài 8 ký tự!");
            return;
        }
        this.id = id;
    }

    public double getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(double avgScore) {
        if (avgScore < 0 || avgScore > 10) {
            System.out.println("Điểm phải từ 0 đến 10");
            return;
        }
        this.avgScore = avgScore;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 18) {
            System.out.println("Tuổi phải lớn hơn hoặc bằng 18");
            return;
        }
        this.age = age;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        if (!className.startsWith("A") && !className.startsWith("C")) {
            System.out.println("Tên lớp phải bắt đầu bằng A hoặc C");
            return;
        }
        this.className = className;
    }

    public void showInfo() {
        System.out.println(this);
    }

    public boolean checkScholarship(Student id) {
        return id.avgScore >= 8;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", avgScore=" + avgScore +
                ", age=" + age +
                ", className='" + className + '\'' +
                '}';
    }
}