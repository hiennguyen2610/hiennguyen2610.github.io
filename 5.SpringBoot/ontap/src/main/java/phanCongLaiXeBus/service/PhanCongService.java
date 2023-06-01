package phanCongLaiXeBus.service;


import phanCongLaiXeBus.model.LaiXe;
import phanCongLaiXeBus.model.PhanCong;
import phanCongLaiXeBus.model.Tuyen;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class PhanCongService {
    private List<PhanCong> danhSachPhanCong;
    private LaiXeService laiXeService;
    private TuyenService tuyenService;
    private Scanner scanner;

    public PhanCongService() {
        danhSachPhanCong = new ArrayList<>();
        laiXeService = new LaiXeService();
        tuyenService = new TuyenService();
        scanner = new Scanner(System.in);
    }

    public void nhapDanhSachPhanCong() {
        List<LaiXe> danhSachLaiXe = laiXeService.layDanhSachLaiXe();
        List<Tuyen> danhSachTuyen = tuyenService.layDanhSachTuyen();

        for (LaiXe laiXe : danhSachLaiXe) {
            System.out.println("\nNhập danh sách phân công cho lái xe " + laiXe.getHoTen() + ":");
            System.out.print("Số lượt phân công (không quá 15): ");
            int soLuot = scanner.nextInt();
            scanner.nextLine();

            if (soLuot > 15) {
                System.out.println("Số lượt phân công vượt quá giới hạn. Chỉ được phân công tối đa 15 lượt.");
                continue; // Quay lại vòng lặp để nhập lại thông tin phân công cho lái xe khác
            }

            List<Tuyen> danhSachTuyenPhanCong = new ArrayList<>();
            for (int i = 0; i < soLuot; i++) {
                System.out.print("Nhập mã tuyến thứ " + (i + 1) + ": ");
                String maTuyen = scanner.nextLine();

                // Kiểm tra xem lái xe đã lái tuyến này chưa
                boolean isTuyenAssigned = false;
                for (PhanCong phanCong : danhSachPhanCong) {
                    if (phanCong.getLaiXe().equals(laiXe) && phanCong.getDanhSachTuyen().stream().anyMatch(t -> t.getMaTuyen().equals(maTuyen))) {
                        isTuyenAssigned = true;
                        break;
                    }
                }

                if (isTuyenAssigned) {
                    System.out.println("Lái xe đã được phân công lái tuyến này. Vui lòng nhập tuyến khác.");
                    i--; // Quay lại nhập lại mã tuyến
                    continue;
                }

                // Tìm tuyến trong danh sách tuyến
                Tuyen tuyenPhanCong = null;
                for (Tuyen tuyen : danhSachTuyen) {
                    if (tuyen.getMaTuyen().equals(maTuyen)) {
                        tuyenPhanCong = tuyen;
                        break;
                    }
                }

                if (tuyenPhanCong != null) {
                    danhSachTuyenPhanCong.add(tuyenPhanCong);
                } else {
                    System.out.println("Không tìm thấy tuyến có mã " + maTuyen);
                    i--; // Quay lại nhập lại mã tuyến
                }
            }

            PhanCong phanCong = new PhanCong(laiXe, danhSachTuyenPhanCong, soLuot);
            danhSachPhanCong.add(phanCong);
        }
    }

    public List<PhanCong> layDanhSachPhanCong() {
        return danhSachPhanCong;
    }

}

