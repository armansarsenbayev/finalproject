package com.example.endterm.midterm1.service.impl;

import lombok.RequiredArgsConstructor;
import com.example.endterm.midterm1.dto.CategoryDto;
import com.example.endterm.midterm1.entity.Category;
import com.example.endterm.midterm1.mapper.CategoryMapper;
import com.example.endterm.midterm1.repository.CategoryRepository;
import com.example.endterm.midterm1.service.CategoryService;
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
        return categoryRepository.findById(id)
                .map(categoryMapper::toDto)
                .orElse(null);
    }


    @Override
    public void addCategory(CategoryDto countryDto) {
        categoryRepository.save(categoryMapper.toEntity(countryDto));
    }

    @Override
    public CategoryDto updateById(Long id, CategoryDto countryDto) {
        Category category = categoryMapper.toEntity(countryDto);

        Category updateCategory = categoryRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Not found"));

        updateCategory.setCategory(category.getCategory());

        return categoryMapper.toDto(categoryRepository.save(category));
    }

    @Override
    public boolean deleteById(Long id) {
        categoryRepository.deleteById(id);
        return true;
    }
}

