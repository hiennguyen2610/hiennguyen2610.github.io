package gson_demo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class WriterJson {
    public static void main(String[] args) {
        // Khởi tạo Object student
        Student student = new Student(1, "Bùi Hiên", 25, "hien@techmaster.vn");

        // Ghi đối tượng student vào file "student.json"
        convertObjectToJsonFile("student.json", student);

        // ********************************************

        // Khởi tạo danh sách student
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Nguyễn A", 30, "a@gmail.com"));
        students.add(new Student(2, "Ngô B", 31, "b@gmail.com"));
        students.add(new Student(3, "Trần C", 23, "c@gmail.com"));
        students.add(new Student(4, "Phan D", 26, "d@gmail.com"));

        // Ghi danh sách student vào file "list-student.json"
        convertObjectToJsonFile("list-student.json", students);
    }

    // Ghi Object JSON file (Object là 1 đối tượng bất kỳ : Có thể là Single Object hoặc List Object)
    public static void convertObjectToJsonFile(String fileName, Object obj) {
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
