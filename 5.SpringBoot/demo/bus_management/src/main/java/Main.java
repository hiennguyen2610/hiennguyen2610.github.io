import constant.TrinhDo;
import entity.LaiXe;
import entity.PhanCong;
import entity.PhanCongDetail;
import entity.Tuyen;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static LaiXe[] DanhSachLaiXe = new LaiXe[100];
    public static Tuyen[] DanhSachTuyen = new Tuyen[100];
    public static PhanCong[] DanhSachPhanCong = new PhanCong[100];

    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        boolean isExit = false;
        do {
            int functionChoice = functionChoice();
            switch (functionChoice) {
                case 1:
                    nhapLaiXe();
                    break;
                case 2:
                    showLaiXe();
                    break;
                case 3:
                    nhapTuyen();
                    break;
                case 4:
                    showTuyen();
                    break;
                case 5:
                    nhapDanhSachPhanCong();
                    break;
                case 6:
                    inDanhSachPhanCong();
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    isExit = true;
            }
        } while (!isExit);
    }

    private static void nhapDanhSachPhanCong() {
        if (kiemTraDanhSachLaiXe() || kiemTraDanhSachTuyen()) {
            System.out.println("Cần thực hiện nhập lái xe và tuyến.");
            return;
        }

        System.out.print("Nhập vào số lượng lái xe muốn phân công: ");
        int soLaiXe = new Scanner(System.in).nextInt();
        for (int i = 0; i < soLaiXe; i++) {

            // Nhập danh sách lái xe phân công
            LaiXe laiXe = nhapLaiXePhanCong(i);

            // Nhập danh sách tuyến lái xe muốn lái
            PhanCongDetail[] phanCongDetails = nhapDanhSachTuyenPhanCong();

            PhanCong phanCong = new PhanCong(laiXe, phanCongDetails);
            savePhanCong(phanCong);
        }

    }

    private static void savePhanCong(PhanCong phanCong) {
        for (int j = 0; j < Main.DanhSachPhanCong.length; j++) {
            if (Main.DanhSachPhanCong[j] == null) {
                Main.DanhSachPhanCong[j] = phanCong;
                break;
            }
        }
    }

    private static PhanCongDetail[] nhapDanhSachTuyenPhanCong() {
        System.out.print("Nhập số lượng tuyến muốn chạy: ");
        int soLuongTuyen = new Scanner(System.in).nextInt();
        int tongLuotChay = 0;

        PhanCongDetail[] phanCongDetails = new PhanCongDetail[soLuongTuyen];
        for (int j = 0; j < soLuongTuyen; j++) {
            System.out.print("Nhập mã tuyến thứ " + (j + 1) + ": ");
            Tuyen tuyen = null;
            do {
                int tuyenID = new Scanner(System.in).nextInt();
                for (int k = 0; k < Main.DanhSachTuyen.length; k++) {
                    if (Main.DanhSachTuyen[k].getId() == tuyenID) {
                        tuyen = Main.DanhSachTuyen[k];
                        break;
                    }
                }
                if (tuyen != null) {
                    break;
                }
                System.out.println("Không tìm thấy mã lái xe trên, vui lòng nhập lại.");
            } while (true);

            System.out.print("Nhập số lượt chạy cho tuyến " + (j + 1) + ": ");
            int soLuotChay = new Scanner(System.in).nextInt();

            tongLuotChay += soLuotChay;

            if (tongLuotChay > 15) {
                System.out.println("Tổng số lượt chạy vượt quá 15. Vui lòng nhập lại.");
                j--;
                tongLuotChay -= soLuotChay;
                continue;
            }

            PhanCongDetail phanCongDetail = new PhanCongDetail(tuyen, soLuotChay);
            for (int h = 0; h < phanCongDetails.length; h++) {
                if (phanCongDetails[h] == null) {
                    phanCongDetails[h] = phanCongDetail;
                }
            }
        }
        return phanCongDetails;
    }

    private static LaiXe nhapLaiXePhanCong(int order) {
        System.out.print("Nhập mã lái xe thứ " + (order + 1) + " muốn phân công: ");
        LaiXe laiXe = null;
        do {
            int lxID = new Scanner(System.in).nextInt();
            for (int j = 0; j < Main.DanhSachLaiXe.length; j++) {
                if (Main.DanhSachLaiXe[j].getId() == lxID) {
                    laiXe = Main.DanhSachLaiXe[j];
                    break;
                }
            }
            if (laiXe != null) {
                break;
            }
            System.out.println("Không tìm thấy mã lái xe trên, vui lòng nhập lại.");
        } while (true);
        return laiXe;
    }

    // In danh sách phân công
    private static void inDanhSachPhanCong() {
        for (int i = 0; i < Main.DanhSachPhanCong.length; i++) {
            if (Main.DanhSachPhanCong[i] != null) {
                System.out.println(Main.DanhSachPhanCong[i]);
            }
        }
    }

    // Check xem danh sách lái xe có rỗng không
    private static boolean kiemTraDanhSachLaiXe() {
        for (int i = 0; i < DanhSachLaiXe.length; i++) {
            if (DanhSachLaiXe[i] != null) {
                return false;
            }
        }
        return true;
    }

    // Check xem danh sách tuyến có rỗng không
    private static boolean kiemTraDanhSachTuyen() {
        for (int i = 0; i < DanhSachTuyen.length; i++) {
            if (DanhSachTuyen[i] != null) {
                return false;
            }
        }
        return true;
    }

    // Nhập lái xe
    private static void nhapLaiXe() {
        System.out.print("Nhập số lượng lái xe muốn thêm: ");
        int soLuongLX = new Scanner(System.in).nextInt();
        for (int i = 0; i < soLuongLX; i++) {
            LaiXe laiXe = new LaiXe();
            System.out.print("Nhập tên lái xe thứ "+(i+1) +": ");
            laiXe.nhapThongTin();
            luuThongTinLaiXe(laiXe);
        }
    }

    // Lưu thông tin lái xe
    private static void luuThongTinLaiXe(LaiXe laiXe) {
        for (int j = 0; j < Main.DanhSachLaiXe.length; j++) {
            if (Main.DanhSachLaiXe[j] == null) {
                Main.DanhSachLaiXe[j] = laiXe;
                return;
            }
        }
    }

    // Hiển thị danh sách lái xe
    private static void showLaiXe() {
        for (LaiXe laiXe : Main.DanhSachLaiXe) {
            if (laiXe != null) {
                System.out.println(laiXe);
            }
        }
    }

    // Nhập tuyến
    private static void nhapTuyen() {
        System.out.print("Nhập số lượng tuyến muốn thêm: ");
        int soLuongTuyen = new Scanner(System.in).nextInt();
        for (int i = 0; i < soLuongTuyen; i++) {
            Tuyen tuyen = new Tuyen();
            System.out.print("Nhập khoảng cách tuyến số "+(i+1) + ": ");
            tuyen.nhapThongTin();
            luuThongTinTuyen(tuyen);
        }
    }

    // Lưu thông tin tuyến
    private static void luuThongTinTuyen( Tuyen tuyen) {
        for (int j = 0; j < DanhSachTuyen.length; j++) {
            if (DanhSachTuyen[j] == null) {
                DanhSachTuyen[j] = tuyen;
                return;
            }
        }
    }

    // Hiển thị danh sách tuyến
    private static void showTuyen() {
        for (Tuyen tuyen : Main.DanhSachTuyen) {
            if (tuyen != null) {
                System.out.println(tuyen);
            }
        }
    }


    // Chọn menu
    private static int functionChoice() {
        showMenu();
        System.out.print("Xin mời chọn chức năng: ");

        int choice = 0;
        do {
            choice = new Scanner(System.in).nextInt();
            if (choice >= 1 && choice <= 8) {
                break;
            }
            System.out.print("Lựa chọn không hợp lệ, vui lòng chọn lại: ");
        } while (true);
        return choice;
    }

    // Menu
    private static void showMenu() {
        System.out.println("----------PHẦN MỀM QUẢN LÝ XE BUS----------");
        System.out.println("1. Nhập tài xe mới.");
        System.out.println("2. In ra danh sách tài xế.");
        System.out.println("3. Nhập tuyến xe mới.");
        System.out.println("4. In ra danh sách các tuyến xe.");
        System.out.println("5. Nhập danh sách phân công cho lái xe.");
        System.out.println("6. In danh sách phân công.");
        System.out.println("7. Sắp xếp danh sách phân công theo họ tên lái xe.");
        System.out.println("8. Sắp xếp danh sách phân công theo số lượng tuyến nhận trong ngày (giảm dần).");
        System.out.println("9. Lập bảng kê tổng khoảng cách chạy xe trong ngày của mỗi lái xe.");
        System.out.println("10. Thoát chương trình.");
    }
}
