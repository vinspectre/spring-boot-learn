package com.example.bookshell.components;

public class Book {
    private String id;
    private String author;
    private String name;
    private int readPercent = 0;

    public void setId(String id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("BookId - %s; Author - %s; Name - %s; Read percent - %s%%", id, author, name, readPercent);
    }

    public void setReadPercent(int percent) {
        this.readPercent = percent;
    }
}