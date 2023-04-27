package btvn;

import java.util.Scanner;

public class display {
    public void run() {
        Scanner sc = new Scanner(System.in);
        boolean isQuit = false;
        int option = 0;
        while (!isQuit) {
            menu();
            System.out.print("Nhập lựa chọn: ");
            option = Integer.parseInt(sc.nextLine());

            switch (option) {
                case 1: {
                    worker.list_workers();
                    break;
                }
                case 2: {
                    factory.list_factory();
                    break;
                }
                default: {
                    System.out.println("Không có");
                }
            }
        }
    }

    public void menu() {
        System.out.println("1 -- Nhập danh sách công nhân mới. In ra danh sách các công nhân đã có.");
        System.out.println("2 -- Nhập danh sách xưởng sản xuất. In ra danh sách xưởng đã có");
        System.out.println("3 -- Lập Bảng danh sách chấm công cho từng công nhân và in danh sách ra màn hình.");
        System.out.println("4 -- Sắp xếp danh sách Bảng danh sách phân công");
        System.out.println("5 -- Lập bảng kê thu nhập cho mỗi công nhân trong tháng.");
    }
}
