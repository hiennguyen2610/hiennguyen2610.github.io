package ticket_booking.backend.service;

import ticket_booking.backend.database.LoginDatabase;
import ticket_booking.backend.model.Login;
import ticket_booking.backend.repository.LoginRepository;
import ticket_booking.backend.request.LoginRequest;
import ticket_booking.backend.utils.FileUtils;

import java.util.regex.Pattern;

public class LoginService {
    private final LoginRepository loginRepository = new LoginRepository();
    public Login loginRequest(LoginRequest loginRequest) {
        Login login = new Login();
        login.setUsername(loginRequest.getUsername());
        login.setPassword(loginRequest.getPassword());
        login.setEmail(loginRequest.getEmail());
        loginRepository.saveUser(login);
        return login;
    }

    // Kiểm tra thông tin đăng nhập
    public Login checkLogin(String email, String password) throws ClassNotFoundException {
        for (Login login : LoginDatabase.users) {
            if (login.getEmail().equals(email) && login.getPassword().equals(password)) {
                System.out.printf("Chào mừng %s, bạn có thể thực hiện các công việc sau: ", login.getUsername());
                System.out.println();
                return login;
            }
        }
        throw new ClassNotFoundException("Tài khoản hoặc mật khẩu không đúng");
    }

    // Kiểm tra mật khẩu
    public boolean checkPassword(String password) {
        if (password.length() >= 7 && password.length() <= 15) {
            return true;
        } return false;
    }

    // Kiểm tra email có bị trùng không
    public boolean checkEmailDB(String email) {
        for (Login login : LoginDatabase.users) {
            if (login.getEmail().equals(email)) {
                return false;
            }
        }
        return true;
    }

    // Định dạng cho Email
    private boolean patternMatches(String email, String regexPattern) {
        return Pattern.compile(regexPattern)
                .matcher(email)
                .matches();
    }

    // Kiểm tra định dạng email
    public boolean checkEmail(String email) {
        String regexPattern = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        return patternMatches(email,regexPattern);
    }

    // Thay đổi mật khẩu
    public void setLoginPassword(String email, String newPassword) {
        for (Login login :
                LoginDatabase.users) {
            if (login.getEmail().equals(email)) {
                login.setPassword(newPassword);
                FileUtils.setDataToFile("account.json", LoginDatabase.users);
                System.out.println("Thay đổi mật khẩu thành công");
            }
        }
    }
}
