package com.sparta.memo.controller;

import com.sparta.memo.dto.BoardRequestDto;
import com.sparta.memo.dto.BoardResponseDto;
import com.sparta.memo.service.BoardService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
// 생성자 공부
// @RequiredArgsConstructor - Lombok 사용
public class BoardController {
    private final BoardService memoService;

    public BoardController(BoardService memoService){
        this.memoService = memoService;
    }

    @PostMapping("/boards")
    public BoardResponseDto createBoards(@RequestBody BoardRequestDto requestDto){
        return memoService.createBoard(requestDto);
    }

    @GetMapping("/memos")
    public List<MemoResponseDto> getMemos(){
        // Map to List
        List<MemoResponseDto> responseList = memoList.values().stream()
                .map(MemoResponseDto::new).toList();
        // for문 대체 가능

        return responseList;
    }
//
//    @PutMapping("/memos/{id}")
//    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto){
//        // 해당 메모가 DB 에서 존재하는지 확인
//        if(memoList.containsKey(id)){
//            // 해당 메모 가져오기
//            Memo memo = memoList.get(id);
//
//            // 메모 수정
//            memo.update(requestDto);
//            return memo.getId();
//        }
//        else{
//            throw new IllegalArgumentException("선택한 메모는 존재하지 않습니다.");
//        }
//    }
//
//    @DeleteMapping("/memos/{id}")
//    public Long deleteMemo(@PathVariable Long id){
//        // 해당 메모가 DBdp 존재하는지 확인
//        if(memoList.containsKey(id)){
//            memoList.remove(id);
//            return id;
//        }
//        else{
//            throw new IllegalArgumentException("선택한 메모는 존재하지 않습니다.");
//        }
//    }
}