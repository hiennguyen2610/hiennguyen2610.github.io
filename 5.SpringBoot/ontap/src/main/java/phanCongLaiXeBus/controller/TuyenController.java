package phanCongLaiXeBus.controller;

import phanCongLaiXeBus.model.Tuyen;
import phanCongLaiXeBus.service.TuyenService;

import java.util.List;


public class TuyenController {
    private TuyenService tuyenService;

    public TuyenController() {
        tuyenService = new TuyenService();
    }

    public void nhapDanhSachTuyen() {
        tuyenService.nhapDanhSachTuyen();
    }

    public void inDanhSachTuyen() {
        List<Tuyen> danhSachTuyen = tuyenService.layDanhSachTuyen();
        System.out.println("Danh sách tuyến:");
        for (Tuyen tuyen : danhSachTuyen) {
            System.out.println(tuyen);
        }
    }
}
