package login_project.frontend;

import login_project.backend.controller.LoginController;
import login_project.backend.exception.NotFoundException;

import java.util.Scanner;

public class LoginUI {
    private final LoginController loginController = new LoginController();

    public void run() {
        boolean isQuit = false;
        Scanner sc = new Scanner(System.in);
        int option = 0;
        while (!isQuit) {
            showMenu();
            try {
                System.out.print("Nhập lựa chọn : ");
                option = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Vui lòng chọn từ 1 đến 3");
                continue;
            }
            switch (option) {
                case 1: {
                    try {
                        System.out.println("-------ĐĂNG NHẬP-------");
                        System.out.print("Nhập email : ");
                        String email = sc.nextLine();

                        System.out.print("Nhập password : ");
                        String password = sc.nextLine();
                        loginController.checkLogin(email,password);

                        boolean isQuitTwo = false;
                        while (!isQuitTwo) {
                            showMenu2();
                            try {
                                System.out.print("Nhập lựa chọn : ");
                                option = Integer.parseInt(sc.nextLine());
                            } catch (Exception e) {
                                System.out.println("Lựa chọn không hợp lệ");
                                continue;
                            }
                            switch (option) {
                                case 1: {
                                    System.out.print("Nhập username : ");
                                    String newUserName = sc.nextLine();
                                    loginController.setUserName(email,newUserName);
                                    break;
                                }
                                case 2: {
                                    System.out.print("Nhập email mới : ");
                                    String newEmail = sc.nextLine();
                                    loginController.setEmail(email,newEmail);
                                    break;
                                }
                                case 3: {
                                    System.out.print("Nhập password mới : ");
                                    String newPassword = sc.nextLine();
                                    loginController.setPassword(email,newPassword);
                                    break;
                                }
                                case 4: {
                                    System.out.println("Quay lại menu chính");
                                    isQuitTwo = true;
                                    break;
                                }
                                case 5: {
                                    System.out.println("Đã thoát thành công!");
                                    isQuitTwo = true;
                                    isQuit = true;
                                    break;
                                }
                                default: {
                                    System.out.println("Lựa chọn không hợp lệ");
                                }
                            }
                        }
                    } catch (NotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 2: {
                    System.out.println("----Đăng ký tài khoản mới----");
                    break;
                }
                case 3: {
                    System.out.print("----Quên mật khẩu----");
                    break;
                }
                case 4: {
                    System.out.println("Thoát");
                    isQuit = true;
                    break;
                }
            }
        }
    }

    private void showMenu() {
        System.out.println("1 -- Đăng nhập");
        System.out.println("2 -- Đăng ký");
        System.out.println("3 -- Quên mật khẩu");
        System.out.println("4 -- Thoát");
    }

    private void showMenu2() {
        System.out.println("1 -- Thay đổi username");
        System.out.println("2 -- Thay đổi email");
        System.out.println("3 -- Thay đổi password");
        System.out.println("4 -- Đăng xuất");
        System.out.println("5 -- Thoát");
    }
}
