package login_project.backend.repository;

import login_project.backend.database.LoginDatabase;
import login_project.backend.model.Login;
import login_project.backend.utils.FileUtils;

import java.util.ArrayList;

public class LoginRepository {

    public ArrayList<Login> findAll() {
        return LoginDatabase.users;
    }

    public void saveUser(Login login) {
        LoginDatabase.users.add(login);
        FileUtils.setDataToFile("account.json",LoginDatabase.users);
    }
}
