package gson_demo;

import com.google.gson.Gson;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FileJson {
    public static void main(String[] args) {
        // Lấy thông tin đối tượng student từ file "student.json"
        Student student = getObjectFromJsonFile("student.json");
        System.out.println("Đọc thông tin từ file student.json");
        System.out.println(student);
        System.out.println();

        // ************************************************

        // Lấy List đối tượng student từ file "list-student.json"
        List<Student> students = getListObjectFromJsonFile("list-student.json");

        // Vì có thể list là null, nên xử lý bằng Optional
        Optional<List<Student>> studentsOptional = Optional.ofNullable(students);

        // In ra thông tin từng Object trong List
        System.out.println("Đọc thông tin từ file list-student.json");
        if(studentsOptional.isPresent()) {
            students.forEach(System.out::println);
        }
    }
    // 1. Lấy Object đơn từ file json
    public static Student getObjectFromJsonFile(String fileName) {
        try {
            // Khởi tạo đối tượng gson
            Gson gson = new Gson();

            // Tạo đối tượng reader để đọc file
            Reader reader = Files.newBufferedReader(Paths.get(fileName));

            // Đọc thông tin từ file và binding và class
            Student student = gson.fromJson(reader, Student.class);

            // Đọc file xong thì đóng lại
            // Và trả về kết quả
            reader.close();
            return student;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // 2. Lấy List object từ file json
    public static List<Student> getListObjectFromJsonFile(String fileName) {
        try {
            // Khởi tạo đối tượng gson
            Gson gson = new Gson();

            // Tạo đối tượng reader để đọc file
            Reader reader = Files.newBufferedReader(Paths.get(fileName));

            // Đọc thông tin từ file và binding và class
            List<Student> students = Arrays.asList(gson.fromJson(reader, Student[].class));

            // Đọc file xong thì đóng lại
            // Và trả về kết quả
            reader.close();
            return students;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }



}
