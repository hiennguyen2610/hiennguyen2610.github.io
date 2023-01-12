package ticket_booking.backend.repository;

import ticket_booking.backend.database.BookingDatabase;
import ticket_booking.backend.model.Booking;
import ticket_booking.backend.utils.FileUtils;

public class BookingRepository {
    public static void saveTicket(Booking booking) {
        BookingDatabase.tickets.add(booking);
        FileUtils.setDataToFile1("ticket.json",BookingDatabase.tickets);
    }
}
