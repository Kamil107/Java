package com.naukaprogramowania.books.book;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "books")
public class Book {

    @Id
    @SequenceGenerator(name = "book_sequence", sequenceName = "book_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_sequence")
    private Long id;
    private String title;
    private String author;
    private LocalDate dateOfPublication;

    public Book(Long id, String title, String author, LocalDate dateOfPublication) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.dateOfPublication = dateOfPublication;
    }

    public Book(String title, String author, LocalDate dateOfPublication) {
        this.title = title;
        this.author = author;
        this.dateOfPublication = dateOfPublication;
    }

    public Book() {
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", dateOfPublication=" + dateOfPublication +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getDateOfPublication() {
        return dateOfPublication;
    }

    public void setDateOfPublication(LocalDate dateOfPublication) {
        this.dateOfPublication = dateOfPublication;
    }
}
