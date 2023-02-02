package ticket_booking.backend.database;

import ticket_booking.backend.model.Login;
import ticket_booking.backend.utils.FileUtils;

import java.util.List;

public class LoginDatabase {
    public static List<Login> users = FileUtils.getDataFromFile("account.json");
}
