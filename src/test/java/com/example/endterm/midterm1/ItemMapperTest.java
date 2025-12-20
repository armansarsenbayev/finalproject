package com.example.endterm.midterm1;

import com.example.endterm.midterm1.dto.ItemDto;
import com.example.endterm.midterm1.entity.Item;
import com.example.endterm.midterm1.mapper.ItemMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

public class ItemMapperTest {

    private final ItemMapper itemMapper = Mappers.getMapper(ItemMapper.class);

    @Test
    void toDtoTest() {
        Item item = new Item();
        item.setId(10L);
        item.setName("Phone");
        item.setDescription("Smartphone");
        item.setPrice(200000);

        ItemDto dto = itemMapper.toDto(item);

        Assertions.assertNotNull(dto);
        Assertions.assertEquals(10L, dto.getId());
        Assertions.assertEquals("Phone", dto.getNameDto());
        Assertions.assertEquals("Smartphone", dto.getDescriptionDto());
        Assertions.assertEquals(200000, dto.getPriceDto());
    }

    @Test
    void toEntityTest() {
        ItemDto dto = ItemDto.builder()
                .id(11L)
                .nameDto("Laptop")
                .descriptionDto("Ultrabook")
                .priceDto(500000)
                .build();

        Item entity = itemMapper.toEntity(dto);

        Assertions.assertNotNull(entity);
        Assertions.assertEquals(11L, entity.getId());
        Assertions.assertEquals("Laptop", entity.getName());
        Assertions.assertEquals("Ultrabook", entity.getDescription());
        Assertions.assertEquals(500000, entity.getPrice());
    }
}
