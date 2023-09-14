package com.example.spring3.Repository;

import com.example.spring3.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findAllByOrderByModifiedAtDesc();
    Optional<Item> findItemById(Long id);
}