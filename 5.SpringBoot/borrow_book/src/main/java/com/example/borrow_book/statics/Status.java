package com.example.borrow_book.statics;

public enum Status {
    NEW("New"), LIKE_NEW("Like new"), VERY_GOOD("Very good"), GOOD("Good"), ACCEPTABLE("OK");

    String name;

    Status(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
