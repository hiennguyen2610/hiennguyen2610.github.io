package book_management.database;

import book_management.model.Book;

public class BookDatabase {
    public static Book[] books = {
            new Book(1, "Những người khốn khổ", "Victor Hugo", "Văn học nước ngoài", "NXB Kim Đồng", 2010),
            new Book(2, "Dế mèn phiêu lưu kí", "Tô Hoài", "Văn học Việt Nam", "NXB Kim Đồng", 2012),
            new Book(3, "Làm đĩ", "Vũ Trọng Phụng", "Văn học Việt Nam", "NXB Nhã Nam", 2004),
            new Book(4, "Hai đứa trẻ", "Thạch Lam", "Văn học Việt Nam", "NXB Trẻ", 2000),
    };
}
