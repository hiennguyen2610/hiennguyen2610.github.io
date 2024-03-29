package phanCongLaiXeBus;

import phanCongLaiXeBus.controller.LaiXeController;
import phanCongLaiXeBus.controller.PhanCongController;
import phanCongLaiXeBus.controller.TuyenController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LaiXeController laiXeController = new LaiXeController();
        TuyenController tuyenController = new TuyenController();
        PhanCongController phanCongController = new PhanCongController();

        int choice = -1;
        while (choice != 0) {
            System.out.println("\n---- MENU ----");
            System.out.println("1. Nhập danh sách lái xe");
            System.out.println("2. In danh sách lái xe");
            System.out.println("3. Nhập danh sách tuyến");
            System.out.println("4. In danh sách tuyến");
            System.out.println("5. Nhập danh sách phân công");
            System.out.println("6. In danh sách phân công");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ ký tự new line

            switch (choice) {
                case 1:
                    laiXeController.nhapDanhSachLaiXe();
                    break;
                case 2:
                    laiXeController.inDanhSachLaiXe();
                    break;
                case 3:
                    tuyenController.nhapDanhSachTuyen();
                    break;
                case 4:
                    tuyenController.inDanhSachTuyen();
                    break;
                case 5:
                    phanCongController.nhapDanhSachPhanCong();
                    break;
                case 6:
                    phanCongController.inDanhSachPhanCong();
                    break;
                case 0:
                    System.out.println("Đã thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        }
    }
}

