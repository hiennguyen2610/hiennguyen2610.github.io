package btvn;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Scanner;

@Getter
@Setter
@Builder
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)


public class worker {
    static int id = 1000;
    String name;
    String adress;
    String phone;
    int level;

    public worker() {
        id++;
        this.id = id;
    }

    public void addWorkers() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên: ");
        name = scanner.nextLine();
        System.out.print("Nhập địa chỉ: ");
        adress = scanner.nextLine();
        System.out.print("Nhập số điện thoại: ");
        phone = scanner.nextLine();
        System.out.print("Cấp bậc: ");
        level = scanner.nextInt();
        System.out.println("Thêm công nhân thành công!");
    }

    public static void list_workers() {
        Logger logger = Logger.getLogger(main.class);
        ArrayList<worker> workers = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int list_workers;
        System.out.print("Nhập số công nhân muốn thêm: ");
        list_workers = sc.nextInt();
        for (int i = 0; i < list_workers; i++) {
            worker worker1 = new worker();
            System.out.println("Nhập công nhân thứ " + (i + 1) + ":");
            worker1.addWorkers();
            workers.add(worker1);
        }

        System.out.println("Danh sách công nhân: ");
        for (worker wk : workers) {
            System.out.println(wk);
        }
        logger.info(workers);
    }
}
