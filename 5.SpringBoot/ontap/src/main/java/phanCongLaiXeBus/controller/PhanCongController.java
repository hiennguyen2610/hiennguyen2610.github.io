package phanCongLaiXeBus.controller;

import phanCongLaiXeBus.model.LaiXe;
import phanCongLaiXeBus.model.Tuyen;
import phanCongLaiXeBus.service.PhanCongService;

import java.util.ArrayList;
import java.util.Scanner;

public class PhanCongController {
    private static PhanCongService phanCongService;
    private static LaiXeController laiXeController;
    private static TuyenController tuyenController;
    private static Scanner scanner;

    public PhanCongController() {
        phanCongService = new PhanCongService();
        laiXeController = new LaiXeController();
        tuyenController = new TuyenController();
        scanner = new Scanner(System.in);
    }

    public static void nhapDanhSachPhanCong() {
        ArrayList<LaiXe> danhSachLaiXe = laiXeController.getDanhSachLaiXe();
        ArrayList<Tuyen> danhSachTuyen = tuyenController.getDanhSachTuyen();

        phanCongService.nhapDanhSachPhanCong(danhSachLaiXe, danhSachTuyen, scanner);
    }

    public static void inDanhSachPhanCong() {
        phanCongService.inDanhSachPhanCong();
    }

    public static void sapXepTheoHoTen() {
        phanCongService.sapXepTheoHoTen();
    }

    public static void sapXepTheoSoLuongTuyen() {
        phanCongService.sapXepTheoSoLuongTuyen();
    }

    public static void inBangKeKhoangCach() {
        phanCongService.inBangKeKhoangCach();
    }
}

