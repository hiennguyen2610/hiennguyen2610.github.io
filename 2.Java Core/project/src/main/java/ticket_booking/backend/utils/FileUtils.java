package ticket_booking.backend.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import ticket_booking.backend.model.Booking;
import ticket_booking.backend.model.Checkin;
import ticket_booking.backend.model.Login;

import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileUtils {

    // Đọc file Json
    public static ArrayList<Login> getDataFromFile(String fileName) {
        try {
            // Khởi tạo đối tượng Gson
            Gson gson = new Gson();

            // Tạo đối tượng reader để đọc file
            Reader reader = Files.newBufferedReader(Paths.get(fileName));

            // Đọc thông tin file và binding và class
            Type type = new TypeToken<ArrayList<Login>>(){}.getType();
            ArrayList<Login> users = gson.fromJson(reader, type);
            reader.close();
            return users;
        } catch (Exception e) {
            // e.printStackTrace();
        }
        return new ArrayList<>();
    }

    // Ghi file Json
    public static void setDataToFile(String fileName, Object obj) {
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Writer writer = Files.newBufferedWriter(Paths.get(fileName));
            gson.toJson(obj, writer);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Đọc file Json
    public static ArrayList<Booking> getDataFromFile1(String fileName) {
        try {
            // Khởi tạo đối tượng Gson
            Gson gson = new Gson();

            // Tạo đối tượng reader để đọc file
            Reader reader = Files.newBufferedReader(Paths.get(fileName));

            // Đọc thông tin file và binding và class
            Type type = new TypeToken<ArrayList<Booking>>(){}.getType();
            ArrayList<Booking> tickets = gson.fromJson(reader, type);
            reader.close();
            return tickets;
        } catch (Exception e) {
            // e.printStackTrace();
        }
        return new ArrayList<>();
    }

    // Ghi file Json
    public static void setDataToFile1(String fileName, Object obj) {
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Writer writer = Files.newBufferedWriter(Paths.get(fileName));
            gson.toJson(obj, writer);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Đọc file Json
    public static ArrayList<Checkin> getDataFromFile2(String fileName) {
        try {
            // Khởi tạo đối tượng Gson
            Gson gson = new Gson();

            // Tạo đối tượng reader để đọc file
            Reader reader = Files.newBufferedReader(Paths.get(fileName));

            // Đọc thông tin file và binding và class
            Type type = new TypeToken<ArrayList<Checkin>>(){}.getType();
            ArrayList<Checkin> checkins = gson.fromJson(reader, type);
            reader.close();
            return checkins;
        } catch (Exception e) {
            // e.printStackTrace();
        }
        return new ArrayList<>();
    }

    // Ghi file Json
    public static void setDataToFile2(String fileName, Object obj) {
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Writer writer = Files.newBufferedWriter(Paths.get(fileName));
            gson.toJson(obj, writer);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
