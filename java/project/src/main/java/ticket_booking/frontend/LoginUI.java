package ticket_booking.frontend;

import ticket_booking.backend.controller.LoginController;
import ticket_booking.backend.model.Login;
import ticket_booking.backend.request.LoginRequest;

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
                System.out.print("Nhập lựa chọn của bạn: ");
                option = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Vui lòng chọn từ 1 đến 4");
                continue;
            }
            switch (option) {
                case 1: {
                    try {
                        System.out.println();
                        System.out.println("-------ĐĂNG NHẬP-------");
                        System.out.print("Nhập email : ");
                        String email = sc.nextLine();
                        System.out.print("Nhập password : ");
                        String password = sc.nextLine();
                        loginController.checkLogin(email, password);
                        BookingUI bookingUI = new BookingUI();
                        bookingUI.booking();
                    } catch (ClassNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 2: {
                    System.out.println();
                    System.out.println("----ĐĂNG KÍ TÀI KHOẢN----");
                    System.out.print("Nhập tên người dùng: ");
                    String userName = sc.nextLine();

                    System.out.print("Nhập email: ");
                    String email = sc.nextLine();
                    if (loginController.checkEmail(email) == true && loginController.checkEmailDB(email) == true) {
                        System.out.print("Nhập password: ");
                        String password = sc.nextLine();
                        if (loginController.checkPassword(password) == false) {
                            System.out.println("Mật khẩu phải từ 7 đến 15 kí tự");
                        } else if (loginController.checkPassword(password) == true) {
                            LoginRequest loginRequest = new LoginRequest(userName, password, email);
                            Login login = loginController.loginRequest(loginRequest);
                            System.out.println("Đăng kí tài khoản thành công!");
                        }
                    } else {
                        System.out.println("Email không đúng định dạng hoặc đã được đăng kí!");
                    }
                    break;
                }
                case 3: {
                    System.out.println();
                    System.out.println("----QUÊN MẬT KHẨU----");
                    System.out.print("Nhập email để thay đổi mật khẩu: ");
                    String email = sc.nextLine();
                    if (loginController.checkEmailDB(email) == false) {
                        System.out.print("Nhập mật khẩu mới: ");
                        String newPassword = sc.nextLine();
                        if (loginController.checkPassword(newPassword) == true) {
                            loginController.setLoginPassword(email, newPassword);
                            System.out.println("Hãy đang nhập lại!");
                            break;
                        } else if (loginController.checkPassword(newPassword) == false) {
                            System.out.println("Mật khẩu phải từ 7 đến 15 kí tự!");
                        }
                    } else if (loginController.checkEmailDB(email) == true) {
                        System.out.println("Tài khoản không tồn tại!");
                    }
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

        // Menu đăng nhập
        private void showMenu() {
            System.out.println("1 -- Đăng nhập");
            System.out.println("2 -- Đăng ký");
            System.out.println("3 -- Quên mật khẩu");
            System.out.println("4 -- Thoát");
        }
    }