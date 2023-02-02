package ticket_booking.backend.controller;

import ticket_booking.backend.model.Booking;
import ticket_booking.backend.request.BookingRequest;
import ticket_booking.backend.service.BookingService;

import java.util.Random;

public class BookingController {
    private final BookingService bookingService = new BookingService();
    public Booking bookingRequest(BookingRequest bookingRequest) {
        return bookingService.bookingRequest(bookingRequest);
    }
    public void findById(int id) {
        bookingService.findById(id);
    }

    public boolean checkTicketExist(int idTicket) {
        return bookingService.checkTicketExist(idTicket);
    }
}
