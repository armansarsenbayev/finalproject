package com.example.endterm.midterm1.service;

import com.example.endterm.midterm1.dto.ItemDto;

import java.util.List;

public interface ItemService {
    List<ItemDto> getAll();
    ItemDto getById(Long id);

    ItemDto addItem(ItemDto itemDto);
    ItemDto updateById(Long id, ItemDto itemDto);
    boolean deletebyId(long id);
}
