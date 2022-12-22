import com.github.javafaker.Faker;

public class Main {
    public static void main(String[] args) {

        // Cach 1: Su dung constructor
        Person person = new Person(1, "Quang Hien", "hien@gmail.com");
        System.out.println(person);

        // Cach 2: Su dung builder
//        Person person1 = Person.builder()
//                .email("a@gmail.com")
//                .name("Nguyen Quang Hien")
//                .build();
//        System.out.println(person1);

        // Tạo nhiều đối tượng person
        Faker faker = new Faker();
        Person[] people = new Person[20];
        for (int i = 0; i < people.length; i++) {
            people[i] = new Person(i + 1, faker.name().fullName(), faker.internet().emailAddress());
        }

        for (Person p: people) {
            System.out.println(p);
        }

        System.out.println(faker.leagueOfLegends().champion());
    }
}
