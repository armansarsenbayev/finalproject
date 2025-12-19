package com.example.endterm.midterm1.service;

import com.example.endterm.midterm1.dto.ItemDto;

import java.util.List;

public interface ItemService {
    List<ItemDto> getAll();
    ItemDto getById(long id);
    ItemDto addItem(ItemDto itemDto);
    ItemDto updateItem(Long id, ItemDto itemDto);
    ItemDto deleteItem(Long id, ItemDto itemDto);
    boolean deletebyId(long id);
}
