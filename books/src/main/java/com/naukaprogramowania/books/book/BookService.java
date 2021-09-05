package com.naukaprogramowania.books.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    public void deleteBook(long bookId) {
        if (bookRepository.existsById(bookId)){
            bookRepository.deleteById(bookId);
        }else {
            throw new IllegalStateException("Book with this id does not exits");
        }
    }

    public void addBook(Book book) {
        Optional<Book> optional = bookRepository.findBookByTitle(book.getTitle());
        if(optional.isPresent()){
            throw new IllegalStateException("Book is already in the database");
        }
        bookRepository.save(book);
    }
}
