package book_management;

import book_management.backend.database.BookDatabase;
import book_management.backend.model.Book;

public class Main {
    public static void main(String[] args) {
        for (Book b :
                BookDatabase.books) {
            System.out.println(b);
        }
    }
}
