package com.example.jpa_relation_test.dto;

import com.example.jpa_relation_test.entity.Book;
import com.example.jpa_relation_test.entity.BookStore;
import lombok.Getter;

@Getter
public class BookResponseDto {
    private Long bookId;
    private String title;
    private String author;
    private Integer price;
    private Integer stock;
    private BookStore bookStore;

    public BookResponseDto(Book book) {
        this.bookId = book.getBookId();
        this.title = book.getTitle();
        this.author = book.getAuthor();
        this.price = book.getPrice();
        this.stock = book.getStock();
        this.bookStore = book.getBookStore();
    }
}
