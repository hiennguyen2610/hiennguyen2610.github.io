package book_management.backend.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor

public class CreateBookRequest {
    private String title;
    private List<String> categories;
    private String author;
    private int pageNumber;
    private int releaseYear;

    public CreateBookRequest(String title, List<String> categories, String author, int pageNumber, int releaseYear) {
        this.title = title;
        this.categories = categories;
        this.author = author;
        this.pageNumber = pageNumber;
        this.releaseYear = releaseYear;
    }

    public CreateBookRequest(String title, String author, int pageNumber, int releaseYear) {
    }
}
