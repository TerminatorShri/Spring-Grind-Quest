package org.spring.rest.controllers;

import org.spring.rest.entities.Book;
import org.spring.rest.services.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books/{bookId}")
    public ResponseEntity<?> getBookById(@PathVariable int bookId) {
        try {
            Book book = bookService.getBookById(bookId);
            if (book != null) {
                return ResponseEntity.ok(book);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error fetching book: " + e.getMessage());
        }
    }

    @GetMapping("/books")
    public ResponseEntity<?> getBooks() {
        try {
            List<Book> books = bookService.getBooks();
            if (books != null && !books.isEmpty()) {
                return ResponseEntity.ok(books);
            } else {
                return ResponseEntity.noContent().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error fetching books: " + e.getMessage());
        }
    }

    @PostMapping("/books")
    public ResponseEntity<?> addBook(@RequestBody Book book) {
        try {
            boolean isAdded = bookService.addBook(book);
            if (isAdded) {
                return ResponseEntity.ok(true);
            } else {
                return ResponseEntity.status(400).body("Book with the same ID already exists or input is invalid.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error adding book: " + e.getMessage());
        }
    }

    @PutMapping("/books/{bookId}")
    public ResponseEntity<?> updateBook(@PathVariable int bookId, @RequestBody Book book) {
        try {
            boolean isUpdated = bookService.updateBook(bookId, book);
            if (isUpdated) {
                return ResponseEntity.ok(true);
            } else {
                return ResponseEntity.status(400).body("Book not found or update failed.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error updating book: " + e.getMessage());
        }
    }

    @DeleteMapping("/books/{bookId}")
    public ResponseEntity<?> deleteBook(@PathVariable int bookId) {
        try {
            boolean isDeleted = bookService.deleteBook(bookId);
            if (isDeleted) {
                return ResponseEntity.ok(true);
            } else {
                return ResponseEntity.status(400).body("Book not found or deletion failed.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error deleting book: " + e.getMessage());
        }
    }
}
