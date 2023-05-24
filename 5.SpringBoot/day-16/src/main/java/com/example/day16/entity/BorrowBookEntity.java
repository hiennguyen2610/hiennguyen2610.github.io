package com.example.day16.entity;

import com.example.homework_book_managerment.statics.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BorrowBookEntity {
    int id;
    ReaderEntity reader;
    com.example.homework_book_managerment.entity.BookEntity book;
    int quantity;
    Status status;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate date;
}
