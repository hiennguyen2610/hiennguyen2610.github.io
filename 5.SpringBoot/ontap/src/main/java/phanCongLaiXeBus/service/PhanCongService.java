package phanCongLaiXeBus.service;


import phanCongLaiXeBus.model.LaiXe;
import phanCongLaiXeBus.model.PhanCong;
import phanCongLaiXeBus.model.Tuyen;

import java.util.*;

public class PhanCongService {
    private ArrayList<PhanCong> danhSachPhanCong;
    private HashMap<LaiXe, Double> bangKeKhoangCach;

    public PhanCongService() {
        danhSachPhanCong = new ArrayList<>();
        bangKeKhoangCach = new HashMap<>();
    }

    public void nhapDanhSachPhanCong(ArrayList<LaiXe> danhSachLaiXe, ArrayList<Tuyen> danhSachTuyen, Scanner scanner) {
        for (LaiXe laiXe : danhSachLaiXe) {
            System.out.println("Nhập danh sách phân công cho lái xe " + laiXe.getHoTen() + ":");
            int soLuot = 0;

            for (Tuyen tuyen : danhSachTuyen) {
                System.out.print("Nhập số lượt lái xe " + laiXe.getHoTen() + " sẽ lái trên tuyến " + tuyen.getMaTuyen() + ": ");
                int luot = scanner.nextInt();
                soLuot += luot;

                PhanCong phanCong = new PhanCong(laiXe, tuyen, luot);
                danhSachPhanCong.add(phanCong);
            }

            bangKeKhoangCach.put(laiXe, tinhTongKhoangCachLaiXe(laiXe));
            if (soLuot > 15) {
                System.out.println("Tổng số lượt của lái xe " + laiXe.getHoTen() + " vượt quá 15. Vui lòng kiểm tra lại.");
            }
        }
    }

    private double tinhTongKhoangCachLaiXe(LaiXe laiXe) {
        double tongKhoangCach = 0;
        for (PhanCong phanCong : danhSachPhanCong) {
            if (phanCong.getLaiXe().equals(laiXe)) {
                tongKhoangCach += phanCong.getTuyen().getKhoangCach();
            }
        }
        return tongKhoangCach;
    }

    public void inDanhSachPhanCong() {
        System.out.println("----- DANH SÁCH PHÂN CÔNG -----");
        for (PhanCong phanCong : danhSachPhanCong) {
            System.out.println(phanCong);
        }
    }

    public void sapXepTheoHoTen() {
        Collections.sort(danhSachPhanCong, new Comparator<PhanCong>() {
            @Override
            public int compare(PhanCong pc1, PhanCong pc2) {
                return pc1.getLaiXe().getHoTen().compareTo(pc2.getLaiXe().getHoTen());
            }
        });
        for (PhanCong phanCong : danhSachPhanCong) {
            System.out.println(phanCong);
        }
    }

    public void sapXepTheoSoLuongTuyen() {
        Collections.sort(danhSachPhanCong, new Comparator<PhanCong>() {
            @Override
            public int compare(PhanCong pc1, PhanCong pc2) {
                return pc2.getSoLuot() - pc1.getSoLuot();
            }
        });
        for (PhanCong phanCong : danhSachPhanCong) {
            System.out.println(phanCong);
        }
    }

    public void inBangKeKhoangCach() {
        Map<LaiXe, Double> tongKhoangCachLaiXe = new HashMap<>();

        for (PhanCong phanCong : danhSachPhanCong) {
            LaiXe laiXe = phanCong.getLaiXe();
            double tongKhoangCach = tinhTongKhoangCachLaiXe(laiXe);

            if (tongKhoangCachLaiXe.containsKey(laiXe)) {
                double tong = tongKhoangCachLaiXe.get(laiXe);
                tong += tongKhoangCach;
                tongKhoangCachLaiXe.put(laiXe, tong);
            } else {
                tongKhoangCachLaiXe.put(laiXe, tongKhoangCach);
            }
        }

        for (Map.Entry<LaiXe, Double> entry : tongKhoangCachLaiXe.entrySet()) {
            LaiXe laiXe = entry.getKey();
            double tong = entry.getValue();

            System.out.println("Lái xe: " + laiXe.getHoTen() + ", Tổng khoảng cách: " + tong);
        }
    }
}

