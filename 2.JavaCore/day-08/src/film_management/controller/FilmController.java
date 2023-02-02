package film_management.controller;

import film_management.service.FilmService;

import java.util.Scanner;

public class FilmController {

    FilmService filmService = new FilmService();

    public void run() {
        Scanner sc = new Scanner(System.in);
        boolean isQuit = true;

        while (isQuit) {
            showMenu();

            System.out.print("Nhập chương trình : ");
            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1: {
                    filmService.showFilm();
                    break;
                }
                case 2: {
                    System.out.println("Nhập tiêu đề phim cần tìm: ");
                    String title = sc.nextLine();
                    filmService.findByTitle(title);
                    break;
                }
                case 3: {
                    isQuit = true;
                    break;
                }
                default: {
                    System.out.println("Lựa chọn không hợp lệ. Chọn lại");
                    break;
                }
            }
        }
    }
    public void showMenu() {
        System.out.println("\n------------MENU------------");
        System.out.println("1. Hiển thị thông tin phim ");
        System.out.println("2. Tìm phim theo tiêu đề");
        System.out.println("3. Thoát");
    }
}
