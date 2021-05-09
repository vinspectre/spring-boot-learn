package com.example.bookshell;

import com.example.bookshell.components.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
Command examples:
get-by-id --id 222
get-by-id 222
create 333 Spectre Invisibility
create --id 444 --name "My Life" --author "Vinni Puh"
set-percent 444 50
set-percent --percent 10 --id 111
all
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
