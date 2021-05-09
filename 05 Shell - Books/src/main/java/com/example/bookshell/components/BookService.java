package com.example.bookshell.components;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Component
@ConfigurationProperties()
public class BookService {
    private List<Book> books = new ArrayList<>();

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void displayBookList() {
        if (books.size() == 0) {
            System.out.println("There is no books");
        } else {
            books.forEach(book -> System.out.println(book.toString()));
        }
    }

    public String getAllBooks() {
        return StringUtils.collectionToDelimitedString(books, "\n");
    }

    public String setPercent(String id, int percent) {
        Book bookById = getBookById(id);
        if (bookById == null) {
            return String.format("Book with id %s not found!", id);
        } else {
            bookById.setReadPercent(percent);
            return bookById.toString();
        }
    }

    public String getById(String id) {
        Book bookById = getBookById(id);
        if (bookById == null) {
            return String.format("Book with id %s not found!", id);
        } else {
            return bookById.toString();
        }
    }

    private Book getBookById(String id) {
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public String create(String id, String author, String name) {
        Book book = new Book();
        book.setAuthor(author);
        book.setId(id);
        book.setName(name);
        books.add(book);
        return book.toString();
    }
}
