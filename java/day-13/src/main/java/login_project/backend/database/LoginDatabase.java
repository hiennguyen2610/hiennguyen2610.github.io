package login_project.backend.database;

import login_project.backend.model.Login;
import login_project.backend.utils.FileUtils;

import java.util.ArrayList;

public class LoginDatabase {
    public static ArrayList<Login> users = FileUtils.getDataFromFile("account.json");
}
