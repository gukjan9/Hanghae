package com.example.jpa_relation_test.dto;

import com.example.jpa_relation_test.entity.BookStore;
import com.example.jpa_relation_test.entity.Member;
import lombok.Getter;

@Getter
public class MemberResponseDto {
    private Long id;
    private String email;
    private String address;
    private String phoneNumber;
    private String nickname;
    private BookStore bookStore;

    public MemberResponseDto(Member member){
        this.id = member.getId();
        this.email = member.getEmail();
        this.address = member.getAddress();
        this.phoneNumber = member.getPhoneNumber();
        this.nickname = member.getNickname();
        this.bookStore = member.getBookStore();
    }
}
