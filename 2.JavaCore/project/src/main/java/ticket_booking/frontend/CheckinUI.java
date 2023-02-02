package ticket_booking.frontend;

import ticket_booking.backend.controller.CheckinController;
import ticket_booking.backend.database.BookingDatabase;
import ticket_booking.backend.database.CheckinDatabase;
import ticket_booking.backend.model.Booking;
import ticket_booking.backend.model.Checkin;
import ticket_booking.backend.request.CheckinRequest;

import java.util.Scanner;

public class CheckinUI {
    private final CheckinController checkinController = new CheckinController();
    public void checkin(int idTicketToChange) {
        boolean isQuit = false;
        Scanner sc = new Scanner(System.in);
        int option = 0;
        while (!isQuit) {
            System.out.println("Bạn có thể thực hiện các hành động sau: ");
            showMenuCheckin();
            try {
                System.out.print("Nhập lựa chọn của bạn: ");
                option = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Vui lòng chọn từ 1 đến 4");
                continue;
            }
            switch (option) {
                case 1: {
                    System.out.println();
                    System.out.println("----THAY ĐỔI HÀNH TRÌNH BAY----");
                    boolean isQuitOne = false;
                    int option1 = 0;
                    while (!isQuitOne) {
                        showMenuCheckin1();
                        try {
                            System.out.print("Nhập lựa chọn của bạn: ");
                            option1 = Integer.parseInt(sc.nextLine());
                        } catch (Exception e) {
                            System.out.println("Vui lòng chọn từ 1 đến 4");
                            continue;
                        }
                        switch (option1) {
                            case 1: {
                                System.out.print("Nhập nơi đi bạn muốn thay đổi: ");
                                String newFrom = sc.nextLine();
                                checkinController.setNewFrom(idTicketToChange,newFrom);
                                System.out.println("Thay đổi vé thành công, thông tin vé của bạn là: ");
                                System.out.printf("%-10s %-10s %-15s %-10s %-10s %-10s %-18s\n", "Mã vé", "Nơi đi", "Nơi đến", "Ngày", "Tháng", "Giờ bay", "Giá vé");
                                for (Booking booking1: BookingDatabase.tickets) {
                                    System.out.printf("%-10d %-10s %-15s %-10d %-10d %-10d %-18d\n", booking1.getId(), booking1.getFrom(), booking1.getTo(), booking1.getDay(), booking1.getMonth(), booking1.getHour(), booking1.getPrice());
                                }
                                break;
                            }
                            case 2: {
                                System.out.print("Nhập nơi đến bạn muốn thay đổi: ");
                                String newTo = sc.nextLine();
                                checkinController.setNewTo(idTicketToChange, newTo);
                                System.out.println("Thay đổi vé thành công, thông tin vé của bạn là: ");
                                System.out.printf("%-10s %-10s %-15s %-10s %-10s %-10s %-18s\n", "Mã vé", "Nơi đi", "Nơi đến", "Ngày", "Tháng", "Giờ bay", "Giá vé");
                                for (Booking booking1: BookingDatabase.tickets) {
                                    System.out.printf("%-10d %-10s %-15s %-10d %-10d %-10d %-18d\n", booking1.getId(), booking1.getFrom(), booking1.getTo(), booking1.getDay(), booking1.getMonth(), booking1.getHour(), booking1.getPrice());
                                }
                                break;
                            }
                            case 3: {
                                System.out.println("Thoát");
                                isQuitOne = true;
                                break;
                            }
                        }
                    }
                    break;
                }
                case 2: {
                    System.out.println();
                    System.out.println("----THAY ĐỔI NGÀY GIỜ BAY----");
                    boolean isQuitTwo = false;
                    int option2 = 0;
                    while (!isQuitTwo) {
                        showMenuCheckin2();
                        try {
                            System.out.print("Nhập lựa chọn của bạn: ");
                            option2 = Integer.parseInt(sc.nextLine());
                        } catch (Exception e) {
                            System.out.println("Vui lòng chọn từ 1 đến 3");
                            continue;
                        }
                        switch (option2) {
                            case 1: {
                                System.out.print("Nhập ngày đi bạn muốn thay đổi: ");
                                int newDay = Integer.parseInt(sc.nextLine());
                                checkinController.setNewDay(idTicketToChange,newDay);
                                System.out.print("Nhập tháng đi bạn muốn thay đổi: ");
                                int newMonth = Integer.parseInt(sc.nextLine());
                                checkinController.setNewMonth(idTicketToChange,newMonth);
                                System.out.println("Thay đổi vé thành công, thông tin vé của bạn là: ");
                                System.out.printf("%-10s %-10s %-15s %-10s %-10s %-10s %-18s\n", "Mã vé", "Nơi đi", "Nơi đến", "Ngày", "Tháng", "Giờ bay", "Giá vé");
                                for (Booking booking1: BookingDatabase.tickets) {
                                    System.out.printf("%-10d %-10s %-15s %-10d %-10d %-10d %-18d\n", booking1.getId(), booking1.getFrom(), booking1.getTo(), booking1.getDay(), booking1.getMonth(), booking1.getHour(), booking1.getPrice());
                                }
                                break;
                            }
                            case 2: {
                                System.out.print("Nhập giờ đi bạn muốn thay đổi: ");
                                int newHour = Integer.parseInt(sc.nextLine());
                                checkinController.setNewHour(idTicketToChange, newHour);
                                System.out.println("Thay đổi vé thành công, thông tin vé của bạn là: ");
                                System.out.printf("%-10s %-10s %-15s %-10s %-10s %-10s %-18s\n", "Mã vé", "Nơi đi", "Nơi đến", "Ngày", "Tháng", "Giờ bay", "Giá vé");
                                for (Booking booking1: BookingDatabase.tickets) {
                                    System.out.printf("%-10d %-10s %-15s %-10d %-10d %-10d %-18d\n", booking1.getId(), booking1.getFrom(), booking1.getTo(), booking1.getDay(), booking1.getMonth(), booking1.getHour(), booking1.getPrice());
                                }
                                break;
                            }
                            case 3: {
                                System.out.println("Thoát");
                                isQuitTwo = true;
                                break;
                            }
                        }
                    }
                    break;
                }
                case 3: {
                    System.out.println();
                    System.out.println("----CHỌN GHẾ NGỒI VÀ MUA THÊM HÀNH LÝ----");
                    System.out.println("Mời nhập lại mã vé: ");
                    int idCheck = Integer.parseInt(sc.nextLine());
                    System.out.print("Chọn ghế ngồi (từ hàng 1 đến 40, dãy A-B-C-D-E-F): ");
                    String seat = sc.nextLine();
                    System.out.print("Nhập số kg hành lý muốn mua thêm: ");
                    int luggage = Integer.parseInt(sc.nextLine());
                    CheckinRequest checkinRequest = new CheckinRequest(luggage, seat);
                    Checkin checkin = checkinController.checkinRequest(checkinRequest);
                    System.out.println("Bạn đã làm thủ tục thành công!");
                    System.out.printf("%-10s %-10s %-15s %-10s %-10s %-10s %-18s\n", "Mã vé", "Nơi đi", "Nơi đến", "Ngày", "Tháng", "Giờ bay", "Giá vé");
                    for (Booking booking1: BookingDatabase.tickets) {
                        System.out.printf("%-10d %-10s %-15s %-10d %-10d %-10d %-18d %-18d %-10s\n", booking1.getId(), booking1.getFrom(), booking1.getTo(), booking1.getDay(), booking1.getMonth(), booking1.getHour(), booking1.getPrice(), checkin.getLuggage(), checkin.getSeat());
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

    // Menu Checkin
    private void showMenuCheckin() {
        System.out.println("1 -- Thay đổi hành trình bay");
        System.out.println("2 -- Thay đổi ngày giờ");
        System.out.println("3 -- Chọn ghế ngồi và mua thêm hành lý");
        System.out.println("4 -- Thoát");
    }

    // Menu thay đổi hành trình
    private void showMenuCheckin1() {
        System.out.println("1 -- Thay đổi điểm đi");
        System.out.println("2 -- Thay đổi điểm đến");
        System.out.println("3 -- Thoát");
    }

    // Menu thay đổi ngày giờ
    private void showMenuCheckin2() {
        System.out.println("1 -- Thay đổi ngày đi");
        System.out.println("2 -- Thay đổi giờ đi");
        System.out.println("3 -- Thoát");
    }
}
