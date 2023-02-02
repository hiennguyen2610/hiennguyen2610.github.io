package ticket_booking.frontend;

import ticket_booking.backend.controller.BookingController;
import ticket_booking.backend.controller.CheckinController;
import ticket_booking.backend.database.BookingDatabase;
import ticket_booking.backend.database.LoginDatabase;
import ticket_booking.backend.model.Booking;
import ticket_booking.backend.model.Login;
import ticket_booking.backend.request.BookingRequest;

import java.util.Random;
import java.util.Scanner;

public class BookingUI {
    private final BookingController bookingController = new BookingController();
    private final CheckinController checkinController = new CheckinController();

    public void booking() {
        boolean isQuit = false;
        Scanner sc = new Scanner(System.in);
        int option = 0;
        while (!isQuit) {
            showMenuBooking();
            try {
                System.out.print("Nhập lựa chọn của bạn: ");
                option = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Vui lòng chọn từ 1 đến 3");
                continue;
            }
            switch (option) {
                case 1: {
                    System.out.println();
                    System.out.println("-------ĐẶT VÉ MÁY BAY-------");
                    Random rd = new Random();
                    int id = rd.nextInt(100000);
                    System.out.print("Nhập điểm đi: ");
                    String from = sc.nextLine();
                    System.out.print("Nhập điểm đến: ");
                    String to = sc.nextLine();
                    System.out.print("Chọn ngày đi: ");
                    int day = Integer.parseInt(sc.nextLine());
                    System.out.print("Chọn tháng: ");
                    int month = Integer.parseInt(sc.nextLine());
                    Random rd2 = new Random();
                    int hour = rd2.nextInt(24);
                    Random rd3 = new Random();
                    int price = rd3.nextInt(5000000);
                    BookingRequest bookingRequest = new BookingRequest(id, from, to, day, month, hour, price);
                    Booking booking = bookingController.bookingRequest(bookingRequest);
                    System.out.println("Đã đặt vé thành công, thông tin vé của bạn là: ");
                    System.out.printf("%-10s %-10s %-15s %-10s %-10s %-10s %-18s\n", "Mã vé", "Nơi đi", "Nơi đến", "Ngày", "Tháng", "Giờ bay", "Giá vé");
                    for (Booking booking1 : BookingDatabase.tickets) {
                        System.out.printf("%-10d %-10s %-15s %-10d %-10d %-10d %-18d\n", booking1.getId(), booking1.getFrom(), booking1.getTo(), booking1.getDay(), booking1.getMonth(), booking1.getHour(), booking1.getPrice());
                    }
                    break;
                }
                case 2: {
                    System.out.println();
                    System.out.println("----CHUYẾN BAY CỦA TÔI----");
                    System.out.print("Nhập id vé của bạn: ");
                    int idTicket = Integer.parseInt(sc.nextLine());
//                    bookingController.findById(idTicket);
                    if (bookingController.checkTicketExist(idTicket)) {
                        for (Booking booking : BookingDatabase.tickets) {
                            if (idTicket == booking.getId()) {
                                CheckinUI checkinUI = new CheckinUI();
                                checkinUI.checkin(idTicket);
                            }
                        }
                    } else {
                        System.out.println("id vé không chính xác!");
                    }
                    break;
                }
                case 3: {
                    System.out.println();
                    System.out.println("----HỦY VÉ----");
                    System.out.print("Nhập mã vé muốn hủy: ");
                    int ticketDelete = Integer.parseInt(sc.nextLine());
                    checkinController.ticketDelete(ticketDelete);
                    break;
                }
                case 4: {
                    System.out.println();
                    System.out.println("----THÔNG TIN VÉ CỦA BẠN----");
                    System.out.printf("%-10s %-10s %-15s %-10s %-10s %-10s %-18s\n", "Mã vé", "Nơi đi", "Nơi đến", "Ngày", "Tháng", "Giờ bay", "Giá vé");
                    for (Booking booking1: BookingDatabase.tickets) {
                        System.out.printf("%-10d %-10s %-15s %-10d %-10d %-10d %-18d\n", booking1.getId(), booking1.getFrom(), booking1.getTo(), booking1.getDay(), booking1.getMonth(), booking1.getHour(), booking1.getPrice());
                    }
                    break;
                }
                case 5: {
                    System.out.println("Thoát");
                    isQuit = true;
                    break;
                }
            }
        }
    }

    // Menu Booking
    private void showMenuBooking() {
        System.out.println("1 -- Đặt vé máy bay");
        System.out.println("2 -- Chuyến bay của tôi");
        System.out.println("3 -- Hủy vé");
        System.out.println("4 -- Thông tin vé");
        System.out.println("5 -- Thoát");
    }
}
