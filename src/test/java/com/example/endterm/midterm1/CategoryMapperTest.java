package com.example.endterm.midterm1;

import com.example.endterm.midterm1.dto.CategoryDto;
import com.example.endterm.midterm1.entity.Category;
import com.example.endterm.midterm1.mapper.CategoryMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

public class CategoryMapperTest {

    private final CategoryMapper categoryMapper = Mappers.getMapper(CategoryMapper.class);

    @Test
    void toDtoTest() {
        Category category = new Category();
        category.setId(1L);
        category.setCategory("Electronics");

        CategoryDto dto = categoryMapper.toDto(category);

        Assertions.assertNotNull(dto);
        Assertions.assertEquals(1L, dto.getId());
        Assertions.assertEquals("Electronics", dto.getCategoryDto());
    }

    @Test
    void toEntityTest() {
        CategoryDto dto = CategoryDto.builder()
                .id(2L)
                .categoryDto("Food")
                .build();

        Category entity = categoryMapper.toEntity(dto);

        Assertions.assertNotNull(entity);
        Assertions.assertEquals(2L, entity.getId());
        Assertions.assertEquals("Food", entity.getCategory());
    }
}
