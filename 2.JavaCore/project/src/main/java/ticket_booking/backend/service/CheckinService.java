package ticket_booking.backend.service;

import ticket_booking.backend.database.BookingDatabase;
import ticket_booking.backend.model.Booking;
import ticket_booking.backend.model.Checkin;
import ticket_booking.backend.repository.CheckinRepository;
import ticket_booking.backend.request.CheckinRequest;
import ticket_booking.backend.utils.FileUtils;

import java.util.ArrayList;
import java.util.List;

public class CheckinService {
    private static final CheckinRepository checkinRepository = new CheckinRepository();
    List<Booking> checkins = checkinRepository.allTicket();
    public Checkin setNewFrom(int idTicketToChange, String newFrom) {
        for (Booking booking : BookingDatabase.tickets) {
            if (booking.getId()==idTicketToChange){
                booking.setFrom(newFrom);
            }
            FileUtils.setDataToFile1("ticket.json", BookingDatabase.tickets);
        }
        return null;
    }

    public void setNewTo(int idTicketToChange, String newTo) {
        for (Booking booking : BookingDatabase.tickets) {
            if (booking.getId()==idTicketToChange){
                booking.setTo(newTo);
            }
            FileUtils.setDataToFile1("ticket.json", BookingDatabase.tickets);
        }
    }

    public void setNewDay(int idTicketToChange,int newDay) {
        for (Booking booking : BookingDatabase.tickets) {
            if (booking.getId()==idTicketToChange){
                booking.setDay(newDay);
            }
            FileUtils.setDataToFile1("ticket.json", BookingDatabase.tickets);
        }
    }

    public void setNewHour(int idTicketToChange, int newHour) {
        for (Booking booking : BookingDatabase.tickets) {
            if (booking.getId()==idTicketToChange){
                booking.setHour(newHour);
            }
            FileUtils.setDataToFile1("ticket.json", BookingDatabase.tickets);
        }
    }

    public void setNewMonth(int idTicketToChange, int newMonth) {
        for (Booking booking : BookingDatabase.tickets) {
            if (booking.getId()==idTicketToChange){
                booking.setMonth(newMonth);
            }
            FileUtils.setDataToFile1("ticket.json", BookingDatabase.tickets);
        }
    }

    public static Checkin checkinRequest(CheckinRequest checkinRequest) {
        Checkin checkin = new Checkin();
        checkin.setLuggage(checkinRequest.getLuggage());
        checkin.setSeat(checkinRequest.getSeat());
        checkinRepository.saveCheckin(checkin);
        return checkin;
    }

    public void ticketDelete(int ticketDelete) {
        ArrayList<Booking> toRemove = new ArrayList<>(){};
        for (Booking booking : checkins) {
            if (booking.getId() == ticketDelete) {
                toRemove.add(booking);
            }
        }
        checkins.removeAll(toRemove);
        System.out.println("Xóa vé thành công!");
    }
}
