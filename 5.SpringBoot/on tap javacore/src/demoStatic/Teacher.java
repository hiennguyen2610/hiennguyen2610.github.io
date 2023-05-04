package demoStatic;

public class Teacher {
    public static int a = 5;

    static {
        System.out.println("Đây là đoạn code static ở trong class Teacher");
    }

    public Teacher() {
        System.out.println("CONSTRUCTOR CỦA CLASS TEACHER");
    }
}
