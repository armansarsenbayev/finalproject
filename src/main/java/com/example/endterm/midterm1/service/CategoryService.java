package com.example.endterm.midterm1.service;

import com.example.endterm.midterm1.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> getAll();
    CategoryDto getById(Long id);
    CategoryDto addCategory(CategoryDto categoryDto);
    CategoryDto updateById(Long id, CategoryDto categoryDto);
    boolean deleteById(Long id);
}
