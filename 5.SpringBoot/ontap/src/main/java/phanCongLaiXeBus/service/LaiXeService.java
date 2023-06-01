package phanCongLaiXeBus.service;

import phanCongLaiXeBus.model.LaiXe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LaiXeService {
    private List<LaiXe> danhSachLaiXe;
    private Scanner scanner;

    public LaiXeService() {
        danhSachLaiXe = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void nhapDanhSachLaiXe() {
        System.out.print("Nhập số lượng lái xe: ");
        int soLuongLaiXe = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < soLuongLaiXe; i++) {
            System.out.println("Nhập thông tin lái xe thứ " + (i + 1) + ":");
            System.out.print("Mã lái xe: ");
            String maLX = scanner.nextLine();
            System.out.print("Họ tên: ");
            String hoTen = scanner.nextLine();
            System.out.print("Địa chỉ: ");
            String diaChi = scanner.nextLine();
            System.out.print("Số điện thoại: ");
            String soDienThoai = scanner.nextLine();
            System.out.print("Trình độ: ");
            String trinhDo = scanner.nextLine();

            LaiXe laiXe = new LaiXe(maLX, hoTen, diaChi, soDienThoai, trinhDo);
            danhSachLaiXe.add(laiXe);
        }
    }

    public List<LaiXe> layDanhSachLaiXe() {
        return danhSachLaiXe;
    }
}
