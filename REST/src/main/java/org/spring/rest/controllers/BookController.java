package org.spring.rest.controllers;

import org.spring.rest.entities.Book;
import org.spring.rest.services.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books/{bookId}")
    public Book getBookById(@PathVariable int bookId) {
        return bookService.getBookById(bookId);
    }

    @GetMapping("/books")
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @PostMapping("/books")
    public boolean addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @PutMapping("/books/{bookId}")
    public boolean updateBook(@PathVariable int bookId, @RequestBody Book book) {
        return bookService.updateBook(bookId, book);
    }

    @DeleteMapping("/books/{bookId}")
    public boolean deleteBook(@PathVariable int bookId) {
        return bookService.deleteBook(bookId);
    }
}
