package upcasting_demo;

public class Test {
    public static void main(String[] args) {

        // Upcasting
        Person p = new Student("Hiển");
        // Đối với các method được overide -> Gọi method của lớp con
        // Đối với các method không được overide -> Gọi method của lớp cha
        p.eat();
        p.sleep();
        p.work();
        ((Student)p).display();

        System.out.println();

        // Downcasting
        Student student = (Student) p;
        student.display();
        student.eat();
        student.sleep();
        student.work();

    }
}
