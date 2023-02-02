package login_project.backend.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class LoginRequest {
    private String username;
    private String password;
    private String email;

    public LoginRequest(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}