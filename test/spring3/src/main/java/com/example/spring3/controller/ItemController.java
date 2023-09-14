package com.example.spring3.controller;

import com.example.spring3.dto.ItemResponseDto;
import com.example.spring3.dto.ItemRequestDto;
import com.example.spring3.dto.StatusDto;
import com.example.spring3.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ItemController {

    private final ItemService itemService;

    // 판매 게시글 생성
    @PostMapping("/post")
    public ItemResponseDto createItem(@RequestBody ItemRequestDto requestDto) {
        return itemService.createItem(requestDto);
    }

    // 게시글 전체 조회
    @GetMapping("/post")
    public List<ItemResponseDto> getItems(){
        return itemService.getItems();
    }

    // 게시글 개별 조회
    @GetMapping("/post/{postId}")
    public ItemResponseDto getItemById(@PathVariable Long id){
        return itemService.getItemById(id);
    }

    // 게시글 수정
    @PutMapping("/post/{postId}/")
    public ItemResponseDto updateItem(@PathVariable Long id, @RequestBody ItemRequestDto requestDto) {
        return itemService.updateItem(id, requestDto);
    }

    @DeleteMapping("/post/{postId}")
    public StatusDto deleteItem(@PathVariable Long id) {
        return itemService.deleteItem(id);
    }
}