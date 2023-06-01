package phanCongLaiXeBus.service;


import phanCongLaiXeBus.model.Tuyen;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TuyenService {
    private List<Tuyen> danhSachTuyen;
    private Scanner scanner;

    public TuyenService() {
        danhSachTuyen = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void nhapDanhSachTuyen() {
        System.out.print("\nNhập số lượng tuyến: ");
        int soLuongTuyen = scanner.nextInt();
        scanner.nextLine(); // Đọc bỏ ký tự new line
        for (int i = 0; i < soLuongTuyen; i++) {
            System.out.println("\nNhập thông tin tuyến thứ " + (i + 1) + ":");
            System.out.print("Mã tuyến: ");
            String maTuyen = scanner.nextLine();
            System.out.print("Khoảng cách: ");
            double khoangCach = scanner.nextDouble();
            System.out.print("Số điểm dừng: ");
            int soDiemDung = scanner.nextInt();

            Tuyen tuyen = new Tuyen(maTuyen, khoangCach, soDiemDung);
            danhSachTuyen.add(tuyen);
        }
    }

    public List<Tuyen> layDanhSachTuyen() {
        return danhSachTuyen;
    }
}

