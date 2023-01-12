package ticket_booking.backend.repository;

import ticket_booking.backend.database.LoginDatabase;
import ticket_booking.backend.model.Login;
import ticket_booking.backend.utils.FileUtils;

public class LoginRepository {
    public void saveUser(Login login) {
        LoginDatabase.users.add(login);
        FileUtils.setDataToFile("account.json",LoginDatabase.users);
    }
}
