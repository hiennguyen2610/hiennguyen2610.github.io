package shop_management.controller;

import shop_management.service.ShopService;

import java.util.Scanner;

public class ShopController {
    public ShopService shopService = new ShopService();
    public void run() {
        Scanner sc = new Scanner(System.in);
        int option = 0;
        boolean isQuit = true;
        while (!isQuit) {
            showMenu();
            System.out.print("Nhập lựa chọn: ");
            option = Integer.parseInt(sc.nextLine());
            switch (option){
                case 1:{
                    System.out.println("Danh sách sản phẩm là: ");
                    shopService.seeAll();
                    break;
                }

                case 2:{
                    System.out.print("Nhập tên cần tìm : ");
                    String name = sc.nextLine();
                    shopService.findByName(name);
                    break;
                }
                case 3:{
                    System.out.println("Nhập id cần tìm: ");
                    int id = Integer.parseInt(sc.nextLine());
                    shopService.findById(id);
                    break;
                }
                case 4:{
                    isQuit =  true;
                    System.out.println("Thoát");
                    break;
                }
                default: {
                    System.out.println("Lựa chọn không hợp lệ");
                    break;
                }
            }
        }
    }

    // Menu
    public static void showMenu(){
        System.out.println("\n********* MENU *********");
        System.out.println("1 - Xem danh sách sản phẩm");
        System.out.println("2 - Tm sản phẩm theo tên");
        System.out.println("3 - Tìm sản phẩm theo id");
        System.out.println("4 - Tìm sản phẩm có số lượng dưới 5");
        System.out.println("5 - Tìm sản phẩm theo mức giá");
        System.out.println("6 - Thoát\n");
    }
}
