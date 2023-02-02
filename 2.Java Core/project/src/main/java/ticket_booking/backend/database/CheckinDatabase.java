package ticket_booking.backend.database;

import ticket_booking.backend.model.Booking;
import ticket_booking.backend.model.Checkin;
import ticket_booking.backend.utils.FileUtils;

import java.util.List;

public class CheckinDatabase {
    public static List<Checkin> checkins = FileUtils.getDataFromFile2("checkin.json");

}
