package phanCongLaiXeBus;

import phanCongLaiXeBus.controller.LaiXeController;
import phanCongLaiXeBus.controller.PhanCongController;
import phanCongLaiXeBus.controller.TuyenController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LaiXeController laiXeController = new LaiXeController();
        TuyenController tuyenController = new TuyenController();
        PhanCongController phanCongController = new PhanCongController();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("----- MENU -----");
            System.out.println("1. Nhập danh sách lái xe");
            System.out.println("2. In danh sách lái xe");
            System.out.println("3. Nhập danh sách tuyến");
            System.out.println("4. In danh sách tuyến");
            System.out.println("5. Nhập danh sách phân công");
            System.out.println("6. In danh sách phân công");
            System.out.println("7. Sắp xếp danh sách phân công theo họ tên lái xe");
            System.out.println("8. Sắp xếp danh sách phân công theo số lượt");
            System.out.println("9. In bảng kê tổng khoảng cách chạy xe");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();
            scanner.nextLine();

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
                case 7:
                    phanCongController.sapXepTheoHoTen();
                    break;
                case 8:
                    phanCongController.sapXepTheoSoLuongTuyen();
                    break;
                case 9:
                    phanCongController.inBangKeKhoangCach();
                    break;
                case 0:
                    System.out.println("Kết thúc chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn ko hợp lệ. ");
            }
        } while (choice != 0);
    }
}

