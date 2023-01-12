package ticket_booking.backend.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

public class Checkin {
    private int luggage;
    private String seat;
}
