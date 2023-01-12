package ticket_booking.backend.service;

import ticket_booking.backend.database.BookingDatabase;
import ticket_booking.backend.model.Booking;
import ticket_booking.backend.repository.BookingRepository;
import ticket_booking.backend.request.BookingRequest;

import java.util.ArrayList;

public class BookingService {
    private static final BookingRepository bookingRepository = new BookingRepository();
    public static Booking bookingRequest(BookingRequest bookingRequest) {
        Booking booking = new Booking();
        booking.setId(bookingRequest.getId());
        booking.setFrom(bookingRequest.getFrom());
        booking.setTo(bookingRequest.getTo());
        booking.setDay(bookingRequest.getDay());
        booking.setMonth(bookingRequest.getMonth());
        booking.setHour(bookingRequest.getHour());
        booking.setPrice(bookingRequest.getPrice());
        bookingRepository.saveTicket(booking);
        return booking;
    }
    public void findById(int id) {
        BookingDatabase.tickets
                .stream()
                .filter(booking -> booking.getId() == id)
                .toList()
                .forEach(System.out::println);
    }

    public boolean checkTicketExist(int idTicket) {
        return BookingDatabase.tickets.stream().anyMatch(n->n.getId()==idTicket);
    }
}
