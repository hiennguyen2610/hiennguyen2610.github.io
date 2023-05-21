package phanCongLaiXeBus.service;

import phanCongLaiXeBus.model.LaiXe;

import java.util.ArrayList;
import java.util.Scanner;

public class LaiXeService {
    private ArrayList<LaiXe> danhSachLaiXe;

    public LaiXeService() {
        danhSachLaiXe = new ArrayList<>();
    }

    public ArrayList<LaiXe> getDanhSachLaiXe() {
        return danhSachLaiXe;
    }

    public void nhapDanhSachLaiXe(int soLuongLaiXe, Scanner scanner) {
        for (int i = 0; i < soLuongLaiXe; i++) {
            System.out.println("Nhập thông tin lái xe thứ " + (i + 1) + ": ");
            System.out.print("Mã LX: ");
            int maLaiXe = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Họ tên: ");
            String hoTen = scanner.nextLine();
            System.out.print("Địa chỉ: ");
            String diaChi = scanner.nextLine();
            System.out.print("Số ĐT: ");
            String soDienThoai = scanner.nextLine();
            System.out.print("Trình độ: ");
            String trinhDo = scanner.nextLine();

            LaiXe laiXe = new LaiXe(maLaiXe, hoTen, diaChi, soDienThoai, trinhDo);
            danhSachLaiXe.add(laiXe);
        }
    }

    public void inDanhSachLaiXe() {
        System.out.println("----- DANH SÁCH LÁI XE -----");
        for (LaiXe laiXe : danhSachLaiXe) {
            System.out.println(laiXe);
        }
    }
}
