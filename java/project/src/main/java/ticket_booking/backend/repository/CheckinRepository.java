package ticket_booking.backend.repository;

import ticket_booking.backend.database.BookingDatabase;
import ticket_booking.backend.database.CheckinDatabase;
import ticket_booking.backend.model.Booking;
import ticket_booking.backend.model.Checkin;
import ticket_booking.backend.utils.FileUtils;

import java.util.List;

public class CheckinRepository {
    public void saveCheckin(Checkin checkin) {
        CheckinDatabase.checkins.add(checkin);
        FileUtils.setDataToFile2("checkin.json",CheckinDatabase.checkins);
    }

    public List<Booking> allTicket() {
        return BookingDatabase.tickets;
    }
}
