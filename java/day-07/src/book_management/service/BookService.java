package book_management.service;

import book_management.repository.BookRepository;
import book_management.model.Book;
public class BookService {
    public BookRepository bookRepository = new BookRepository();
    public void findByTitle(String title) {
        int count = 0;
        for (Book book: bookRepository.findAll()) {
            if (book.title.toLowerCase().contains(title.toLowerCase())) {
                System.out.println(book);
                count++;
            }
        }

        if (count == 0) {
            System.out.println("Không có quyển sách nào có tiêu đề = " + title);
        }
    }
        // Tìm sách theo thể loại
    public void findByCategory(String category) {
        int count = 0;
        for (Book book: bookRepository.findAll()) {
            if (book.category.toLowerCase().contains(category.toLowerCase())) {
                System.out.println(book);
                count++;
            }
        }

        if (count == 0) {
            System.out.println("Không có quyển sách nào có thể loại = " + category);
        }
    }

    // Liệt kê sách có cùng năm xuất bản
    public void findByYear(int year) {
        int count = 0;
        for (Book book: bookRepository.findAll()) {
            if (book.year == year) {
                System.out.println(book);
                count++;
            }
        }

        if (count == 0) {
            System.out.println("Không có quyển sách nào có năm xuất bản = " + year);
        }
    }
}
