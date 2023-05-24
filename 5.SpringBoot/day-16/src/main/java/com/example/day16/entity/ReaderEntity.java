package com.example.day16.entity;

import com.example.homework_book_managerment.statics.ReaderType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReaderEntity extends com.example.homework_book_managerment.entity.PersonEntity {
    ReaderType readerType;

    public ReaderEntity(int id, String name, String address, String phone, ReaderType readerType) {
        super(id, name, address, phone);
        this.readerType = readerType;
    }
}
