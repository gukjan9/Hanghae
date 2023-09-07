package com.example.jpa_relation_test.entity;

import com.example.jpa_relation_test.dto.BookRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private Integer price;

    private Integer stock;

    @ManyToOne
    private BookStore bookStore;

    @OneToMany(mappedBy = "book")
    private List<Purchase> purchaseList = new ArrayList<>();

    public void update(Book book) {
        this.price = book.getPrice();
        this.stock = book.getStock();
    }

    public void transfer(BookStore bookstore){
        this.bookStore = bookStore;
    }
}
