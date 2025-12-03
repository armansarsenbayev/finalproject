package com.example.endterm.midterm1.service;

import com.example.endterm.midterm1.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> getAll();
    CategoryDto getById(Long id);
    void addCategory(CategoryDto itemDto);
    CategoryDto updateById(Long id, CategoryDto itemDto);
    boolean deleteById(Long id);
}