package com.example.endterm.midterm1.service.impl;

import com.example.endterm.midterm1.dto.CategoryDto;
import com.example.endterm.midterm1.entity.Category;
import com.example.endterm.midterm1.mapper.CategoryMapper;
import com.example.endterm.midterm1.repository.CategoryRepository;
import com.example.endterm.midterm1.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public List<CategoryDto> getAll() {
        return categoryMapper.toDtoList(categoryRepository.findAll());
    }

    @Override
    public CategoryDto getById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Not found"));
        return categoryMapper.toDto(category);
    }

    @Override
    public CategoryDto addCategory(CategoryDto categoryDto) {
        Category saved = categoryRepository.save(categoryMapper.toEntity(categoryDto));
        return categoryMapper.toDto(saved);
    }

    @Override
    public CategoryDto updateById(Long id, CategoryDto categoryDto) {
        Category existing = categoryRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Not found"));

        Category incoming = categoryMapper.toEntity(categoryDto);
        existing.setCategory(incoming.getCategory());

        Category saved = categoryRepository.save(existing);
        return categoryMapper.toDto(saved);
    }

    @Override
    public boolean deleteById(Long id) {
        if (!categoryRepository.existsById(id)) return false;
        categoryRepository.deleteById(id);
        return true;
    }
}
