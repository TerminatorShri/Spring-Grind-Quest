package org.spring.rest.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;
    private String bookName;

    @OneToOne(cascade = CascadeType.ALL)
    private Author bookAuthor;

    public Book() {
    }

    public Book(int bookId, String bookName, Author bookAuthor) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Author getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(Author bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    @Override
    public String toString() {
        return "Book{ " +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", authorName='" + bookAuthor + '\'' +
                " }";
    }
}
