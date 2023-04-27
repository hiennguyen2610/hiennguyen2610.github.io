package btvn;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.Scanner;

@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)

public class factory {
    static int id = 100;
    String name;
    String description;
    double evaluate;

    public factory() {
        id++;
        this.id = id;
    }
    public void addFactory() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên xưởng: ");
        name = scanner.nextLine();
        System.out.println("Chức năng, nhiệm vụ: ");
        description = scanner.nextLine();
        System.out.println("Hệ số công việc: ");
        evaluate = scanner.nextDouble();
        System.out.println("Thêm xưởng thành công!");
    }

    public static void list_factory() {
        ArrayList<factory> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int nums_factory;
        System.out.print("Nhập số xưởng cần thêm: ");
        nums_factory = sc.nextInt();
        for (int i = 0; i < nums_factory; i++) {
            factory fac = new factory();
            System.out.println("Nhập thông tin xưởng thứ " + (i + 1) + ":");
            fac.addFactory();
            list.add(fac);
        }

        System.out.println("Danh sách các xưởng:");
        for (factory ft : list) {
            System.out.println(ft);
        }
    }
}

