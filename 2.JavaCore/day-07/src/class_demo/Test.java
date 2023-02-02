package class_demo;

public class Test {
    public static void main(String[] args) {
        // Tạo ra đối tượng
        Person person = new Person();

        System.out.println(person.name);  // null (default value của String)
        System.out.println(person.age);

        // Gán các giá trị cho thuộc tính của đối tượng
        person.name = "Nguyễn Văn A";
        person.address = "Hà Nội";
        person.age = 20;
        person.email = "hien@gmail.com";

        // In ra thông tin của đối tượng
        System.out.println(person.name + " - " + person.email + " - " + person.address);

        // Gọi phương thức
        person.showInfo();
        person.eat();
        person.play("Bóng đá");

        System.out.println(person.toString());

        // Khởi tạo đối tượng phone
        Phone phone = new Phone();
        phone.name = "iPhone 13 pro";
        phone.brand = "Apple";

        // Khởi tạo đối tượng Calculator
        Calculator calculator = new Calculator();
        calculator.number2 = 5;
        calculator.number1 = 10;

        System.out.println(calculator.division());

        // Khởi tạo đối tượng Person với Constructor
        Person person1 = new Person("Trần Văn B", "b@gmail.com");
        System.out.println(person1);
        Person person2 = new Person("Trần Thị C", "c@gmail.com", 30, "Hải Phòng");
        System.out.println(person2);
    }


}
