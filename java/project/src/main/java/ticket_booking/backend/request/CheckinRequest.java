package ticket_booking.backend.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class CheckinRequest {
    private int luggage;
    private String seat;
    public CheckinRequest(int luggage, String seat) {
        this.luggage = luggage;
        this.seat = seat;
    }
}
