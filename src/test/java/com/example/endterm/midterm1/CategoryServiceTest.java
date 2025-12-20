package com.example.endterm.midterm1;

import com.example.endterm.midterm1.dto.CategoryDto;
import com.example.endterm.midterm1.service.CategoryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

@SpringBootTest
@ActiveProfiles("test")
public class CategoryServiceTest {

    @Autowired
    private CategoryService categoryService;

    @Test
    void getAllTest() {
        List<CategoryDto> dtos = categoryService.getAll();

        Assertions.assertNotNull(dtos);
        Assertions.assertNotEquals(0, dtos.size());

        for (int i = 0; i < dtos.size(); i++) {
            CategoryDto dto = dtos.get(i);

            Assertions.assertNotNull(dto);
            Assertions.assertNotNull(dto.getId());
            Assertions.assertNotNull(dto.getCategoryDto());
        }
    }

    @Test
    void getByIdTest() {
        Random random = new Random();

        int randomIndex = random.nextInt(categoryService.getAll().size());
        Long someId = categoryService.getAll().get(randomIndex).getId();

        CategoryDto dto = categoryService.getById(someId);

        Assertions.assertNotNull(dto);
        Assertions.assertNotNull(dto.getId());
        Assertions.assertNotNull(dto.getCategoryDto());

        Assertions.assertThrows(NoSuchElementException.class, () -> categoryService.getById(-1L));

    }

    @Test
    void addTest() {
        CategoryDto dto = CategoryDto.builder()
                .categoryDto("NewCategory")
                .build();

        CategoryDto added = categoryService.addCategory(dto);

        Assertions.assertNotNull(added);
        Assertions.assertNotNull(added.getId());
        Assertions.assertNotNull(added.getCategoryDto());

        CategoryDto fromDb = categoryService.getById(added.getId());

        Assertions.assertNotNull(fromDb);
        Assertions.assertEquals(added.getId(), fromDb.getId());
        Assertions.assertEquals(added.getCategoryDto(), fromDb.getCategoryDto());
    }

    @Test
    void updateTest() {
        Random random = new Random();
        int randomIndex = random.nextInt(categoryService.getAll().size());
        Long someId = categoryService.getAll().get(randomIndex).getId();

        CategoryDto newDto = CategoryDto.builder()
                .id(someId)
                .categoryDto("UpdatedCategory")
                .build();

        CategoryDto updated = categoryService.updateById(someId, newDto);

        Assertions.assertNotNull(updated);
        Assertions.assertEquals(someId, updated.getId());
        Assertions.assertEquals("UpdatedCategory", updated.getCategoryDto());

        CategoryDto check = categoryService.getById(someId);
        Assertions.assertNotNull(check);
        Assertions.assertEquals(updated.getId(), check.getId());
        Assertions.assertEquals(updated.getCategoryDto(), check.getCategoryDto());
    }

    @Test
    void deleteTest() {

        List<CategoryDto> all = categoryService.getAll();

        if (all.isEmpty()) {
            CategoryDto dto = new CategoryDto();
            dto.setCategoryDto("seed-category");
            categoryService.addCategory(dto);
            all = categoryService.getAll();
        }

        Random random = new Random();
        int randomIndex = random.nextInt(all.size());
        Long someId = all.get(randomIndex).getId();

        categoryService.deleteById(someId);

        Assertions.assertThrows(NoSuchElementException.class, () -> categoryService.getById(someId));
    }

}
