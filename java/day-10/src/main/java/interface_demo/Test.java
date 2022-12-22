package interface_demo;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        IShape iShape = new Rectangle(4, 5);
        System.out.println(iShape.getArea());
        System.out.println(iShape.getPerimeter());

        IShape iShape1 = new Square(5);
        System.out.println(iShape1.getArea());
        System.out.println(iShape1.getPerimeter());

        ArrayList<IShape> shapes = new ArrayList<>();
        shapes.add(iShape);
        shapes.add(iShape1);
        shapes.add(new Rectangle(5,10));
        shapes.add(new Square(9));

        System.out.println("Danh sách hình: ");
        for (IShape s :
                shapes) {
            System.out.println(s.getPerimeter());
            System.out.println(s.getArea());
        }

        // In ra thông tin hình vuông có trong danh sách + diện tích + chu vi
        System.out.println("Danh sách hình vuông: ");
        for (IShape s : shapes) {
            if (s instanceof Square) {
                System.out.println(s);
                System.out.println(s.getArea());
                System.out.println(s.getPerimeter());
            }
        }

        System.out.println(IShape.mesage);
        IShape.hi();
        iShape1.sayHello();
        iShape.sayHello();
    }
}
