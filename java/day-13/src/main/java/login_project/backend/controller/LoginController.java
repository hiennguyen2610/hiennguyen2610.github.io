package login_project.backend.controller;

import login_project.backend.model.Login;
import login_project.backend.request.LoginRequest;
import login_project.backend.service.LoginService;

import java.util.ArrayList;

public class LoginController {
    private final LoginService loginService = new LoginService();
    public ArrayList<Login> getUser() {
        return loginService.getUser();
    }

    public Login loginRequest(LoginRequest request) {
        return loginService.loginRequest(request);
    }

    public void checkLogin(String email, String password) {
        loginService.checkLogin(email,password);
    }

    public void setUserName(String email, String newUserName) {
        loginService.setUserName(email,newUserName);
    }

    public void setEmail(String email, String newEmail) {
        loginService.setEmail(email,newEmail);
    }

    public void setPassword(String email, String newPassword) {
        loginService.setPassword(email,newPassword);
    }
}
