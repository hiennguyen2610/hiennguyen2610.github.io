package ticket_booking.backend.database;

import ticket_booking.backend.model.Booking;
import ticket_booking.backend.utils.FileUtils;

import java.util.List;

public class BookingDatabase {
    public static List<Booking> tickets = FileUtils.getDataFromFile1("tickets.json");
}
