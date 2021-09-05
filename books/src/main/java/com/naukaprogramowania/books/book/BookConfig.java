package com.naukaprogramowania.books.book;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class BookConfig {

    @Bean
    CommandLineRunner commandLineRunner(BookRepository bookRepository){
        return args -> {
            Book bookOne = new Book(1L, "Lord of the Rings", "J.R.R Tolkien", LocalDate.of(1954, Month.JULY, 29));
            Book bookTwo = new Book(2L, "Year 1984", "George Orwell", LocalDate.of(1949, Month.JUNE, 8));
            bookRepository.saveAll(List.of(bookOne, bookTwo));
        };
    }
}
