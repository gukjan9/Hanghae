package com.example.jpa_relation_test.service;

import com.example.jpa_relation_test.dto.BookResponseDto;
import com.example.jpa_relation_test.dto.MemberRequestDto;
import com.example.jpa_relation_test.dto.MemberResponseDto;
import com.example.jpa_relation_test.entity.Book;
import com.example.jpa_relation_test.entity.BookStore;
import com.example.jpa_relation_test.entity.Member;
import com.example.jpa_relation_test.repository.BookRepository;
import com.example.jpa_relation_test.repository.BookStoreRepository;
import com.example.jpa_relation_test.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestService {
    private final BookRepository bookRepository;
    private final MemberRepository memberRepository;
    private final BookStoreRepository bookStoreRepository;

    @Transactional
    public MemberResponseDto signup(MemberRequestDto requestDto) {
        Member member = memberRepository.save(new Member(requestDto));
        return new MemberResponseDto(member);
    }

    public List<Member> findAllMember() {
        return memberRepository.findAll();
    }

    @Transactional
    public void updateBook(Book book, Long bookStoreId, Long bookId) {
        Book newBook = bookRepository.findByBookStoreIdAndBookId(bookStoreId, bookId).orElseThrow(() ->
                new IllegalArgumentException("선택한 Book은 존재하지 않습니다.")
        );
        newBook.update(book);
    }

    @Transactional
    public List<Book> findBook(Long bookStoreId) {
        return bookRepository.findByBookStoreId(bookStoreId);
    }

    @Transactional
    public void transferBook(Long bookId, Long bookStoreId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow();
        BookStore bookStore = bookStoreRepository.findById(bookStoreId)
                .orElseThrow();

        bookStore.addBook(book);
        book.transfer(bookStore);
    }
}
