package com.example.endterm.midterm1.controller;

import com.example.endterm.midterm1.dto.ItemDto;
import com.example.endterm.midterm1.service.ItemService;
import lombok.RequiredArgsConstructor;
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
    public List<ItemDto> getAll() {
        return itemService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemDto> getById(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(itemService.getById(id));
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ItemDto> add(@RequestBody ItemDto itemDto) {
        return ResponseEntity.ok(itemService.addItem(itemDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemDto> update(@PathVariable("id") Long id, @RequestBody ItemDto itemDto) {
        try {
            return ResponseEntity.ok(itemService.updateById(id, itemDto));
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        boolean deleted = itemService.deletebyId(id);
        if (deleted) return ResponseEntity.ok().build();
        return ResponseEntity.notFound().build();
    }
}
