package phanCongLaiXeBus.controller;

import phanCongLaiXeBus.model.LaiXe;
import phanCongLaiXeBus.service.LaiXeService;

import java.util.List;


public class LaiXeController {
    private LaiXeService laiXeService;

    public LaiXeController() {
        laiXeService = new LaiXeService();
    }

    public void nhapDanhSachLaiXe() {
        laiXeService.nhapDanhSachLaiXe();
    }

    public void inDanhSachLaiXe() {
        List<LaiXe> danhSachLaiXe = laiXeService.layDanhSachLaiXe();
        System.out.println("Danh sách lái xe:");
        for (LaiXe laiXe : danhSachLaiXe) {
            System.out.println(laiXe);
        }
    }
}

