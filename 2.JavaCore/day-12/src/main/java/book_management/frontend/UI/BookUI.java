package book_management.frontend.UI;

import book_management.backend.controller.BookController;
import book_management.backend.exception.NotFoundException;
import book_management.backend.model.Book;
import book_management.backend.request.CreateBookRequest;

import java.util.List;
import java.util.Scanner;

public class BookUI {
    private final BookController bookController = new BookController();
        public void run() {
            Scanner sc = new Scanner(System.in);
            int option = 0;
            boolean isQuit = true;
            while (!isQuit) {
                showMenu();
                try {
                    System.out.print("Nhập lựa chọn: ");
                    option = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Lựa chọn không hợp lệ");
                    continue;
                }

                switch (option) {
                    case 1: {
                        List<Book> books = bookController.getBooks();
                        if (books.isEmpty()) {
                            System.out.println("Khong co quyen sach nao trong danh sach");
                        } else {
                            System.out.println("Danh sach books: ");
                            for (Book b : books) {
                                System.out.println(b);
                            }
                        }
                        break;
                    }

                    case 2: {
                        System.out.println("Nhập tên sách: ");
                        String name = sc.nextLine();

                        List<Book> books = bookController.getBooksByName(name);
                        if (books.isEmpty()) {
                            System.out.println("Không có quyển sách nào có tên là: " + name);
                        } else {
                            System.out.println("Danh sách book có tên: " + name + " là: ");
                            for (Book b : books) {
                                System.out.println(b);
                            }
                        }
                        break;
                    }

                    case 3: {
                        System.out.print("Nhập id cần xóa: ");
                        int id = Integer.parseInt(sc.nextLine());

                        try {
                            bookController.deleteBook(id);
                        } catch (NotFoundException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    }

                    case 4: {
                        System.out.println("Nhập vào tiêu đề: ");
                        String title = sc.nextLine();

                        System.out.println("Nhập vào tên tác giả: ");
                        String author = sc.nextLine();

                        System.out.println("Nhập vào số trang sách: ");
                        int pageNumber = Integer.parseInt(sc.nextLine());

                        System.out.println("Nhập vào năm xuất bản: ");
                        int releaseYear = Integer.parseInt(sc.nextLine());

                        CreateBookRequest request = new CreateBookRequest(title, author, pageNumber, releaseYear);
                        Book book = bookController.createBook(request);

                        System.out.println("Quyển sách sau khi tạo là: ");
                        System.out.println(book);
                    }
                    case 5: {
                        isQuit = true;
                        System.out.println("Thoát");
                        break;
                    }
                    default: {
                        System.out.println("Lựa chọn không hợp lệ");
                        break;
                    }
                }
            }
        }

        // Menu
        public static void showMenu() {
            System.out.println("\n********* MENU *********");
            System.out.println("1 - Xem danh sách Books");
            System.out.println("2 - Tm sản phẩm theo tên");
            System.out.println("3 - Xóa sách theo tên");
            System.out.println("4 - Thoát\n");
        }
}
