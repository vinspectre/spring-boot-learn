package com.example.bookshell.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class BookCommands {
    private final BookService bookService;

    @Autowired
    public BookCommands(BookService bookService) {
        this.bookService = bookService;
    }

    @ShellMethod("all")
    public String all() {
        return bookService.getAllBooks();
    }

    @ShellMethod("set-percent")
    public String setPercent(
            @ShellOption String id,
            @ShellOption int percent
    ) {
        return bookService.setPercent(id, percent);
    }

    @ShellMethod("get-by-id")
    public String getById(
            @ShellOption String id
    ) {
        return bookService.getById(id);
    }

    @ShellMethod("create")
    public String create(
            @ShellOption String id,
            @ShellOption String author,
            @ShellOption String name
    ) {
        return bookService.create(id, author, name);
    }
}
