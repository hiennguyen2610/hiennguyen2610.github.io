package phanCongLaiXeBus.controller;

import phanCongLaiXeBus.model.PhanCong;
import phanCongLaiXeBus.service.PhanCongService;

import java.util.List;


public class PhanCongController {
    private PhanCongService phanCongService;

    public PhanCongController() {
        phanCongService = new PhanCongService();
    }

    public void nhapDanhSachPhanCong() {
        phanCongService.nhapDanhSachPhanCong();
    }

    public void inDanhSachPhanCong() {
        List<PhanCong> danhSachPhanCong = phanCongService.layDanhSachPhanCong();
        System.out.println("Danh sách phân công:");
        for (PhanCong phanCong : danhSachPhanCong) {
            System.out.println(phanCong);
        }
    }
}

