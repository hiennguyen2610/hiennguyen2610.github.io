package com.example.borrow_book.model;

import com.example.borrow_book.statics.Specialized;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Book {
    int id;

    @Size(max = 50, message = "Title cannot over 50 characters")
    @NotBlank(message = "Title cannot be blank!")
    String title;

    @Size(max = 50, message = "Author cannot over 50 characters")
    @NotBlank(message = "Author cannot be blank!")
    String author;
    Specialized specialized;

    @NotNull(message = "Publish year cannot empty!")
    @Pattern(regexp = "\\d{4}", message = "Publish year must be 4 number characters")
    @Range(min = 1000, max = 2023, message = "Publish year should be greater than 1000 and less than 2023!")
    String publishDate;
}
