package org.spring.rest.services;

import org.spring.rest.entities.Book;
import org.spring.rest.repositories.BookRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks() {
        List<Book> bookList = new ArrayList<>();
        try {
            bookList = bookRepository.findAll();
        } catch (Exception e) {
            System.out.println("Error fetching books: " + e.getMessage());
        }
        return bookList;
    }

    public Book getBookById(int id) {
        Book book = null;
        try {
            book = bookRepository.findById(id).orElse(null);
        } catch (Exception e) {
            System.out.println("Error fetching book: " + e.getMessage());
        }
        return book;
    }

    public Boolean addBook(Book book) {
        try {
            if (book.getBookName() == null || book.getBookAuthor() == null) {
                return false;
            }
            bookRepository.save(book);
            return true;
        } catch (Exception e) {
            System.out.println("Error adding book: " + e.getMessage());
            return false;
        }
    }

    public Boolean updateBook(int id, Book book) {
        try {
            if (book.getBookName() == null || book.getBookAuthor() == null) {
                return false;
            }
            Book existingBook = bookRepository.findById(id).orElse(null);
            if (existingBook != null) {
                existingBook.setBookName(book.getBookName());
                existingBook.setBookAuthor(book.getBookAuthor());
                bookRepository.save(existingBook);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error updating book: " + e.getMessage());
            return false;
        }
    }

    public Boolean deleteBook(int id) {
        try {
            bookRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            System.out.println("Error deleting book: " + e.getMessage());
            return false;
        }
    }
}
