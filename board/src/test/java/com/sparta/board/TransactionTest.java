package com.sparta.board;

import com.sparta.board.entity.Board;
import com.sparta.board.repository.BoardRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
public class TransactionTest {

    @PersistenceContext
    EntityManager em;

    @Autowired
    BoardRepository boardRepository;

    @Test
    @Transactional
    @Rollback(value = false) // 테스트 코드에서 @Transactional 를 사용하면 테스트가 완료된 후 롤백하기 때문에 false 옵션 추가
    @DisplayName("메모 생성 성공")
    void test1() {
        Board board = new Board();
        board.setTitle("테스트1");
        board.setContents("@Transactional 테스트 중!");
        board.setUsername("Romio");
        board.setPassword("1234a");

        em.persist(board);  // 영속성 컨텍스트에 메모 Entity 객체를 저장합니다.
    }
}