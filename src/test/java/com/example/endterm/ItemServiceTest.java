package com.example.endterm.midterm1;

import com.example.endterm.midterm1.dto.ItemDto;
import com.example.endterm.midterm1.service.ItemService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;

@SpringBootTest
public class ItemServiceTest {

    @Autowired
    private ItemService itemService;

    @Test
    void getAllTest() {

        List<ItemDto> itemDtos = itemService.getAll();

        Assertions.assertNotNull(itemDtos);

        Assertions.assertNotEquals(0, itemDtos.size());

        for (int i = 0; i < itemDtos.size(); i++) {
            ItemDto dto = itemDtos.get(i);

            Assertions.assertNotNull(dto);

            Assertions.assertNotNull(dto.getId());
            Assertions.assertNotNull(dto.getNameDto());
            Assertions.assertTrue(dto.getPriceDto() >= 0);
        }

    }

    @Test
    void getByIdTest() {

        Random random = new Random();

        int randomIndex = random.nextInt(itemService.getAll().size());

        Long someIndex = itemService.getAll().get(randomIndex).getId();

        ItemDto itemDto = itemService.getById(someIndex);

        Assertions.assertNotNull(itemDto);

        Assertions.assertNotNull(itemDto.getId());
        Assertions.assertNotNull(itemDto.getNameDto());
        Assertions.assertTrue(itemDto.getPriceDto() >= 0);

        ItemDto check = itemService.getById(-1L);
        Assertions.assertNull(check);

    }

    @Test
    void addTest() {

        ItemDto itemDto = new ItemDto();
        itemDto.setNameDto("phone");
        itemDto.setPriceDto(200000);

        ItemDto add = itemService.addItem(itemDto);

        Assertions.assertNotNull(add);
        Assertions.assertNotNull(add.getNameDto());
        Assertions.assertNotNull(add.getId());
        Assertions.assertTrue(add.getPriceDto() > 0);

        ItemDto added = itemService.getById(add.getId());

        Assertions.assertNotNull(added);
        Assertions.assertNotNull(added.getId());
        Assertions.assertNotNull(added.getNameDto());
        Assertions.assertTrue(added.getPriceDto() > 0);

        Assertions.assertEquals(add.getId(), added.getId());
        Assertions.assertEquals(add.getNameDto(), added.getNameDto());
        Assertions.assertEquals(add.getPriceDto(), added.getPriceDto());

    }

    @Test
    void updateTest() {

        Random random = new Random();

        int randomIndex = random.nextInt(itemService.getAll().size());

        Long someIndex = itemService.getAll().get(randomIndex).getId();

        ItemDto newItem = ItemDto
                .builder()
                .id(someIndex)
                .priceDto(200000)
                .nameDto("phone")
                .build();

        ItemDto update = itemService.updateById(newItem.getId(), newItem);

        Assertions.assertNotNull(update);

        Assertions.assertNotNull(update.getId());
        Assertions.assertTrue(update.getPriceDto() > 0);
        Assertions.assertNotNull(update.getNameDto());

        Assertions.assertEquals(newItem.getId(), update.getId());
        Assertions.assertEquals(newItem.getPriceDto(), update.getPriceDto());
        Assertions.assertEquals(newItem.getNameDto(), update.getNameDto());

        ItemDto updatedItem = itemService.getById(someIndex);

        Assertions.assertNotNull(updatedItem);

        Assertions.assertNotNull(updatedItem.getId());
        Assertions.assertNotNull(updatedItem.getNameDto());
        Assertions.assertTrue(updatedItem.getPriceDto() > 0);

        Assertions.assertEquals(update.getId(), updatedItem.getId());
        Assertions.assertEquals(update.getNameDto(), updatedItem.getNameDto());
        Assertions.assertEquals(update.getPriceDto(), updatedItem.getPriceDto());

    }

    @Test
    void deleteTest() {

        Random random = new Random();

        int randomIndex = random.nextInt(itemService.getAll().size());

        Long someIndex = itemService.getAll().get(randomIndex).getId();

        Assertions.assertTrue(itemService.deleteById(someIndex));

        ItemDto deleted = itemService.getById(someIndex);

        Assertions.assertNull(deleted);

    }

}
