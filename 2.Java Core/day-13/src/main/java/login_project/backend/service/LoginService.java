package login_project.backend.service;

import login_project.backend.database.LoginDatabase;
import login_project.backend.exception.NotFoundException;
import login_project.backend.model.Login;
import login_project.backend.repository.LoginRepository;
import login_project.backend.request.LoginRequest;
import login_project.backend.utils.FileUtils;

import java.util.ArrayList;

public class LoginService {
    private final LoginRepository loginRepository = new LoginRepository();
    public ArrayList<Login> getUser() {
        return loginRepository.findAll();
    }

    public Login loginRequest(LoginRequest request) {
        Login login = new Login();
        login.setUsername(request.getUsername());
        login.setPassword(request.getPassword());
        login.setEmail(request.getEmail());
        loginRepository.saveUser(login);
        return login;
    }

    public Login checkLogin(String email, String password) {
        for (Login login: LoginDatabase.users) {
            if (login.getEmail().equals(email) && login.getPassword().equals(password)) {
                System.out.printf("Chào mừng %s, bạn có thể thực hiện các công việc sau : ", login.getUsername());
                return login;
            }
        } throw new NotFoundException("Tài khoản hoặc mật khẩu không chính xác");
    }

    public void setUserName(String email, String newUserName) {
        for (Login login: LoginDatabase.users) {
            if (login.getEmail().equals(email)) {
                login.setUsername(newUserName);
                FileUtils.setDataToFile("account.json",LoginDatabase.users);
                System.out.println("Thay đổi username thành công");
            }
        }
    }

    public void setEmail(String email, String newEmail) {
        for (Login login: LoginDatabase.users) {
            if (login.getEmail().equals(email)) {
                login.setEmail(newEmail);
                FileUtils.setDataToFile("account.json",LoginDatabase.users);
                System.out.println("Thay đổi Email thành công");
            }
        }
    }

    public void setPassword(String email, String newPassword) {
        for (Login login: LoginDatabase.users) {
            if (login.getEmail().equals(email)) {
                login.setPassword(newPassword);
                FileUtils.setDataToFile("account.json",LoginDatabase.users);
                System.out.println("Thay đổi password thành công");
            }
        }
    }
}
