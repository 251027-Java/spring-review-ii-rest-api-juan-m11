package com.revature.library.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.revature.library.model.Book;
import com.revature.library.repository.BookRepository;

@Configuration
public class DataSeeder {
    
    @Bean
    CommandLineRunner seedBooks(BookRepository bookRepository) {
        return args -> {

            if (bookRepository.count() == 0) {
                bookRepository.save(new Book("Clean Code", "Robert Martin", "9780132350884"));
                bookRepository.save(new Book("The Pragmatic Programmer", "David Thomas", "9780201616224"));
                bookRepository.save(new Book("Design Patterns", "Gang of Four", "9780201633610"));
                bookRepository.save(new Book("Effective Java", "Joshua Bloch", "9780134685991"));
                bookRepository.save(new Book("Spring in Action", "Craig Walls", "9781617294945"));

                System.out.println("Seeded initial books into the database!");
            }
        };
    }
}
