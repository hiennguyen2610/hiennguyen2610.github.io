package encapsulation_demo;

public class Test {
    public static void main(String[] args) {
        Person person = new Person();
        person.setId(1);
        person.setName("Quang Hiển");
        person.setAge(24);
        person.setEmail("hien@gmail.com");

        System.out.println(person);

        Student std = new Student("MSV123", 8.5, 24, "20");

        std.showInfo();

        System.out.println(std.checkScholarship(std));

    }
}