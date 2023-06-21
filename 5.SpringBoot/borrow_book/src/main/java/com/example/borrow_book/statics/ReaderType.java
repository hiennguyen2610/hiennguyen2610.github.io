package com.example.borrow_book.statics;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ReaderType {
    STUDENT("Student"), POST_GRADUATE("Post Graduate"), TEACHER("Teacher");

    String name;

}
