package ticket_booking.backend.model;

import lombok.*;

import java.util.Random;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

public class Booking {
    private int id;
    private String from;
    private String to;
    private int day;
    private int month;
    private int hour;
    private int price;

//    public void setPrice(int price) {
//    }
//
//    public void setId(int id) {
//    }
//
//    public void setHour(int hour) {
//    }
}
