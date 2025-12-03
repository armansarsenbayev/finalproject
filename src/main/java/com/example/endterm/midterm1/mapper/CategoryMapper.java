package com.example.endterm.midterm1.mapper;

import com.example.endterm.midterm1.dto.CategoryDto;
import com.example.endterm.midterm1.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mapping(target = "categoryDto", source = "category")
    CategoryDto toDto(Category category);

    @Mapping(target = "category", source = "categoryDto")
    Category toEntity(CategoryDto categoryDto);

    List<CategoryDto> toDtoList(List<Category> categories);
}
