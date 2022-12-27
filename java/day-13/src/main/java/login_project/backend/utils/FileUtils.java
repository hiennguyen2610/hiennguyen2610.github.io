package login_project.backend.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import login_project.backend.model.Login;

import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileUtils {

    public static ArrayList<Login> getDataFromFile(String fileName) {
        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get(fileName));
            Type type = new TypeToken<ArrayList<Login>>(){}.getType();
            ArrayList<Login> users = gson.fromJson(reader, type);
            reader.close();
            return users;
        } catch (Exception e) {
            // e.printStackTrace();
        }
        return new ArrayList<>();
    }

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
}
