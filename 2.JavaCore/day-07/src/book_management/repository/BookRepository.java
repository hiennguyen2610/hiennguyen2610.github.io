package book_management.repository;

import book_management.database.BookDatabase;
import book_management.model.Book;

public class BookRepository {
    public Book[] findAll() {
        return BookDatabase.books;
    }
}
