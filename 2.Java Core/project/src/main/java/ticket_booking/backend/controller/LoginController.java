package ticket_booking.backend.controller;

import ticket_booking.backend.model.Login;
import ticket_booking.backend.request.LoginRequest;
import ticket_booking.backend.service.LoginService;

public class LoginController {
    private final LoginService loginService = new LoginService();
    public void checkLogin(String email, String password) throws ClassNotFoundException {
        loginService.checkLogin(email, password);
    }

    public boolean checkPassword(String password) {
        return loginService.checkPassword(password);
    }

    public boolean checkEmail(String email) {
        return loginService.checkEmail(email);
    }

    public boolean checkEmailDB(String email) {
        return loginService.checkEmailDB(email);
    }

    public Login loginRequest(LoginRequest loginRequest) {
        return loginService.loginRequest(loginRequest);
    }

    public void setLoginPassword(String email, String newPassword) {
        loginService.setLoginPassword(email, newPassword);
    }
}
