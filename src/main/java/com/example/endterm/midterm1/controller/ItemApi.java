package com.example.endterm.midterm1.controller;

import lombok.RequiredArgsConstructor;
import com.example.endterm.midterm1.dto.ItemDto;
import com.example.endterm.midterm1.service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/item")
public class ItemApi {
    private final ItemService itemService;

    @GetMapping
    public List<ItemDto> getAll(){
        return itemService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemDto> getById(
            @PathVariable("id") Long id
    ) {
        try {
            return ResponseEntity.ok(itemService.getById(id));
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public void addItem(
            @RequestBody ItemDto itemDto
    ) {
        itemService.addItem(itemDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemDto> updateById(
            @PathVariable("id") Long id,
            @RequestBody ItemDto itemDto
    ) {
        try {
            return ResponseEntity.ok(itemService.updateById(id, itemDto));
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteById(
            @PathVariable("id") Long id
    ) {
        itemService.deleteById(id);
    }
}
