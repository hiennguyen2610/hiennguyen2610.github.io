package com.example.borrow_book.entity;

import com.example.borrow_book.statics.Specialized;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookEntity {
    int id;
    String title;
    String author;
    Specialized specialized;
    String publishDate;

}
