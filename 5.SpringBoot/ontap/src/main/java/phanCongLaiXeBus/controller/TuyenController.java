package phanCongLaiXeBus.controller;

import phanCongLaiXeBus.model.Tuyen;
import phanCongLaiXeBus.service.TuyenService;

import java.util.ArrayList;
import java.util.Scanner;

public class TuyenController {
    private static TuyenService tuyenService;
    private static Scanner scanner;

    public TuyenController() {
        tuyenService = new TuyenService();
        scanner = new Scanner(System.in);
    }

    public static void nhapDanhSachTuyen() {
        System.out.print("Nhập số lượng tuyến: ");
        int soLuongTuyen = scanner.nextInt();
        scanner.nextLine();

        tuyenService.nhapDanhSachTuyen(soLuongTuyen, scanner);
    }

    public static void inDanhSachTuyen() {
        tuyenService.inDanhSachTuyen();
    }

    public ArrayList<Tuyen> getDanhSachTuyen() {
        return tuyenService.getDanhSachTuyen();
    }
}
