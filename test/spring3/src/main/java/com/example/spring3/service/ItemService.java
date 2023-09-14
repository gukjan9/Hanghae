package com.example.spring3.service;

import com.example.spring3.Repository.ItemRepository;
import com.example.spring3.dto.ItemResponseDto;
import com.example.spring3.dto.ItemRequestDto;
import com.example.spring3.dto.StatusDto;
import com.example.spring3.entity.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemResponseDto createItem(ItemRequestDto requestDto) {
        Item item = itemRepository.save(new Item(requestDto));
        return new ItemResponseDto(item);
    }

    public List<ItemResponseDto> getItems() {
        return itemRepository.findAllByOrderByModifiedAtDesc().stream().map(ItemResponseDto::new).toList();
    }

    public ItemResponseDto getItemById(Long id){
        Item item = itemRepository.findItemById(id).orElseThrow(() ->
                new RuntimeException("게시글이 존재하지 않습니다.")
        );
        return new ItemResponseDto(item);
    }

    @Transactional
    public ItemResponseDto updateItem(Long id, ItemRequestDto requestDto) {
        Item item = findItem(id);

        item.update(requestDto);
        return new ItemResponseDto(item);
    }

    @Transactional
    public StatusDto deleteItem(Long id) {
        Item item = findItem(id);

        itemRepository.delete(item);
        return new StatusDto("삭제완료");
    }

    private Item findItem(Long id) {
        return itemRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 게시글은 존재하지 않습니다.")
        );
    }
}