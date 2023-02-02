package ticket_booking.backend.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

public class Login {
    private String username;
    private String password;
    private String email;
}
