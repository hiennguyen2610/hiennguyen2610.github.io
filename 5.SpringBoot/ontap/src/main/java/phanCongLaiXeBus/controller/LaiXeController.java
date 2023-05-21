package phanCongLaiXeBus.controller;


import phanCongLaiXeBus.model.LaiXe;
import phanCongLaiXeBus.service.LaiXeService;

import java.util.ArrayList;
import java.util.Scanner;

public class LaiXeController {
    private static LaiXeService laiXeService;
    private static Scanner scanner;

    public LaiXeController() {
        laiXeService = new LaiXeService();
        scanner = new Scanner(System.in);
    }

    public static void nhapDanhSachLaiXe() {
        System.out.print("Nhập số lượng lái xe: ");
        int soLuongLaiXe = scanner.nextInt();
        scanner.nextLine();
        laiXeService.nhapDanhSachLaiXe(soLuongLaiXe, scanner);
    }

    public static void inDanhSachLaiXe() {
        laiXeService.inDanhSachLaiXe();
    }

    public static ArrayList<LaiXe> getDanhSachLaiXe() {
        return laiXeService.getDanhSachLaiXe();
    }
}

