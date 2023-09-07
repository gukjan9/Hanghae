package com.example.jpa_relation_test.entity;

import com.example.jpa_relation_test.dto.MemberRequestDto;
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
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String email;
    @Column
    private String password;
    @Column
    private String address;
    @Column
    private String phoneNumber;
    @Column
    private String nickname;

    @ManyToOne
    @JoinColumn(name="sparta_store_id")
    private BookStore bookStore;

    @OneToMany(mappedBy = "member")
    private List<Purchase> purchaseList = new ArrayList<>();

    public Member(MemberRequestDto requestDto){
        this.email = requestDto.getEmail();
        this.password = requestDto.getPassword();
        this.address = requestDto.getAddress();
        this.phoneNumber = requestDto.getPhoneNumber();
        this.nickname = requestDto.getNickname();
    }
}
