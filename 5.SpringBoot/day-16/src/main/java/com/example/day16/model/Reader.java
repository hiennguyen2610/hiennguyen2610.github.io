package com.example.day16.model;

import com.example.homework_book_managerment.statics.ReaderType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Reader extends com.example.homework_book_managerment.model.Person {
    ReaderType readerType;

    public Reader(int id, String name, String address, String phone, ReaderType readerType) {
        super(id, name, address, phone);
        this.readerType = readerType;
    }

}
