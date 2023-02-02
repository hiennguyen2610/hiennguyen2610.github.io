package ticket_booking.backend.controller;

import ticket_booking.backend.model.Checkin;
import ticket_booking.backend.request.CheckinRequest;
import ticket_booking.backend.service.CheckinService;

public class CheckinController {
    private final CheckinService checkinService = new CheckinService();
    public Checkin setNewFrom(int idTicketToChange, String newFrom) {
       return checkinService.setNewFrom(idTicketToChange,newFrom);
    }

    public void setNewTo(int idTicketToChange, String newTo) {
        checkinService.setNewTo(idTicketToChange, newTo);
    }

    public void setNewDay(int idTicketToChange, int newDay) {
        checkinService.setNewDay(idTicketToChange, newDay);
    }

    public void setNewHour(int idTicketToChange,int newHour) {
        checkinService.setNewHour(idTicketToChange, newHour);
    }

    public void setNewMonth(int idTicketToChange, int newMonth) {
        checkinService.setNewMonth(idTicketToChange, newMonth);
    }

    public Checkin checkinRequest(CheckinRequest checkinRequest) {
        return checkinService.checkinRequest(checkinRequest);
    }

    public void ticketDelete(int ticketDelete) {
        checkinService.ticketDelete(ticketDelete);
    }
}
