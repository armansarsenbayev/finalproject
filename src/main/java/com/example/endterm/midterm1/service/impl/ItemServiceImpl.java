package com.example.endterm.midterm1.service.impl;

import lombok.RequiredArgsConstructor;
import com.example.endterm.midterm1.dto.ItemDto;
import com.example.endterm.midterm1.entity.Item;
import com.example.endterm.midterm1.mapper.ItemMapper;
import com.example.endterm.midterm1.repository.ItemRepository;
import com.example.endterm.midterm1.service.ItemService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    @Override
    public List<ItemDto> getAll() {
        return itemMapper.toDtoList(itemRepository.findAll());
    }

    @Override
    public ItemDto getById(Long id) {
        return itemMapper.toDto(
                itemRepository.findById(id).orElse(null)
        );
    }

    @Override
    public ItemDto addItem(ItemDto itemDto) {
        Item saved = itemRepository.save(itemMapper.toEntity(itemDto));
        return itemMapper.toDto(saved);
    }

    @Override
    public ItemDto updateById(Long id, ItemDto itemDto) {
        Item updateItem = itemRepository.findById(id).orElseThrow(() ->
                new NoSuchElementException("Not found"));

        updateItem.setName(itemDto.getNameDto());
        updateItem.setDescription(itemDto.getDescriptionDto());
        updateItem.setPrice(itemDto.getPriceDto());
        updateItem.setCategory(itemMapper.toEntity(itemDto).getCategory());
        updateItem.setCountries(itemMapper.toEntity(itemDto).getCountries());

        Item saved = itemRepository.save(updateItem);

        return itemMapper.toDto(saved);
    }

    @Override
    public boolean deleteById(Long id) {
        if (!itemRepository.existsById(id)) {
            return false;
        }
        itemRepository.deleteById(id);
        return true;
    }
}
