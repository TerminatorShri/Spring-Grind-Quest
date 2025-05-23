package org.spring.rest.services;

import org.spring.rest.entities.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookService {
    private static final List<Book> bookList = new ArrayList<Book>();

    static {
        Book book1 = new Book(1, "Book 1", "Author 1");
        Book book2 = new Book(2, "Book 2", "Author 2");
        Book book3 = new Book(3, "Book 3", "Author 3");
        Book book4 = new Book(4, "Book 4", "Author 4");
        Book book5 = new Book(5, "Book 5", "Author 5");

        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        bookList.add(book4);
        bookList.add(book5);
    }

    public List<Book> getBooks() {
        return bookList;
    }

    public Book getBookById(int id) {
        for (Book book : bookList) {
            if (book.getBookId() == id) {
                return book;
            }
        }
        return null;
    }


}
