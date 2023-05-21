package phanCongLaiXeBus.service;


import phanCongLaiXeBus.model.Tuyen;

import java.util.ArrayList;
import java.util.Scanner;

public class TuyenService {
    private ArrayList<Tuyen> danhSachTuyen;

    public TuyenService() {
        danhSachTuyen = new ArrayList<>();
    }

    public ArrayList<Tuyen> getDanhSachTuyen() {
        return danhSachTuyen;
    }

    public void nhapDanhSachTuyen(int soLuongTuyen, Scanner scanner) {
        for (int i = 0; i < soLuongTuyen; i++) {
            System.out.println("Nhập thông tin tuyến thứ " + (i + 1) + ":");
            System.out.print("Mã tuyến: ");
            int maTuyen = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng new line sau khi nhập mã tuyến
            System.out.print("Khoảng cách: ");
            double khoangCach = scanner.nextDouble();
            System.out.print("Số điểm dừng: ");
            int soDiemDung = scanner.nextInt();

            Tuyen tuyen = new Tuyen(maTuyen, khoangCach, soDiemDung);
            danhSachTuyen.add(tuyen);
        }
    }

    public void inDanhSachTuyen() {
        System.out.println("----- DANH SÁCH TUYẾN -----");
        for (Tuyen tuyen : danhSachTuyen) {
            System.out.println(tuyen);
        }
    }
}

