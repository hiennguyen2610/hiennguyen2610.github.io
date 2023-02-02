package ticket_booking.backend.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class LoginRequest {
    private String username;
    private String password;
    private String email;
    public LoginRequest(String userName, String password, String email) {
        this.username = userName;
        this.password = password;
        this.email = email;
    }

}
