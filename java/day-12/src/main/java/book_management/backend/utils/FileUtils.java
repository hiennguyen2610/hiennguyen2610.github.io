package book_management.backend.utils;

import book_management.backend.model.Book;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class FileUtils {
    // 2. Lấy List object từ file json
    public static List<Book> getDataFromFile(String fileName) {
        try {
            // Khởi tạo đối tượng gson
            Gson gson = new Gson();

            // Tạo đối tượng reader để đọc file
            Reader reader = Files.newBufferedReader(Paths.get(fileName));

            // Đọc thông tin từ file và binding và class
            List<Book> students = Arrays.asList(gson.fromJson(reader, Book[].class));

            // Đọc file xong thì đóng lại
            // Và trả về kết quả
            reader.close();
            return students;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // Ghi Object JSON file (Object là 1 đối tượng bất kỳ : Có thể là Single Object hoặc List Object)
    public void setDataToFile(String fileName, Object obj) {
        try {
            // Tạo đối tượng gson
            // Gson gson = new Gson();

            // Nếu muốn format JSON cho đẹp
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            // Tạo đối tượng Writer để ghi nội dung vào file
            Writer writer = Files.newBufferedWriter(Paths.get(fileName));

            // Ghi object vào file
            gson.toJson(obj, writer);

            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
