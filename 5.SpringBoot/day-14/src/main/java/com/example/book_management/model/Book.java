package com.example.book_management.model;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder

public class Book {
    int id;
    String name;
    String author;
    String specialized;
    int publishDate;
}
