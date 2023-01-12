package ticket_booking.backend.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class BookingRequest {
    private int id;
    private String from;
    private String to;
    private int day;
    private int month;
    private int hour;
    private int price;

    public BookingRequest(int id, String from, String to, int day, int month, int hour, int price) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.day = day;
        this.month = month;
        this.hour = hour;
        this.price = price;
    }

}
