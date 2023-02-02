package interface_demo;
import lombok.*;


public interface IShape {
    double getArea();
    double getPerimeter();

    String mesage = "shape"; //public, static, final

    default void sayHello() {
        System.out.println("Hello Shape");
    }

    static void hi() {
        System.out.println("Hi");
    }
}
