package book_management;

import book_management.controller.BookController;

public class Main {
    // Chi tiết các layer
    // controller: Tiếp nhận request từ người dùng (thực hiện chức năng)
    // model: Chứa các đối tượng (Student, Persion ...)
    // service: Chứa business logic của ứng dụng.
    // repository: Chứa phương thức để lấy dữ liệu
    // database: Chưa dữ liệu của ứng dụng
    // actor --> gửi request (1,2,3) --> controller --> gửi thông tin request --> service --> repository

    public static void main(String[] args) {
        BookController bookController = new BookController();
        bookController.run();
    }
}
