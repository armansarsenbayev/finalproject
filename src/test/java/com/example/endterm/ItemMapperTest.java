package com.example.endterm;


import  com.example.endterm.midterm1.dto.ItemDto;
import  com.example.endterm.midterm1.entity.Category;
import  com.example.endterm.midterm1.entity.Country;
import  com.example.endterm.midterm1.entity.Item;
import  com.example.endterm.midterm1.mapper.ItemMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ItemMapperTest {

    @Autowired
    private ItemMapper itemMapper;

    @Test
    public void ConvertEntitytoDtoTest() {

        Category category = new Category();
        Item newItem = new Item();

        Country country = new Country();
        country.setId(1L);
        country.setCountry("Kazakhstan");
        country.setCode("KZ");

        List<Country> countries = new ArrayList<>();
        countries.add(country);

        Item item = new Item();
        item.setId(1L);
        item.setName("Phone");
        item.setDescription("Smartphone");
        item.setPrice(200000);

        item.setCategory(category);
        item.setCountries(countries);

        ItemDto dto = itemMapper.toDto(item);

        Assertions.assertNotNull(dto);

        Assertions.assertNotNull(dto.getId());
        Assertions.assertNotNull((dto.getDescriptionDto()));
        Assertions.assertNotNull(dto.getNameDto());
        Assertions.assertNotNull(dto.getPriceDto());
        Assertions.assertNotNull(dto.getCategoryDto());
        Assertions.assertNotNull(dto.getCountriesDto());


        Assertions.assertEquals(dto.getId(), item.getId());
        Assertions.assertEquals(dto.getNameDto(), item.getName());
        Assertions.assertEquals(dto.getDescriptionDto(), item.getDescription());
        Assertions.assertEquals(dto.getPriceDto(), item.getPrice());
        Assertions.assertEquals(dto.getCategoryDto(), item.getCategory());
        Assertions.assertEquals(dto.getCountriesDto(), item.getCountries());

    }
    @Test
    public void ConvertDtotoEntityTest() {

        Category category = new Category();
        category.setId(1L);

        Country country = new Country();
        country.setId(1L);
        country.setCountry("Kazakhstan");
        country.setCode("KZ");

        List<Country> countries = new ArrayList<>();
        countries.add(country);

        ItemDto dto = ItemDto.builder()
                .id(1L)
                .nameDto("Phone")
                .descriptionDto("Smartphone")
                .priceDto(200000)
                .categoryDto(category)
                .countriesDto(countries)
                .build();
        Item item = itemMapper.toEntity(dto);

        Assertions.assertNotNull(item);

        Assertions.assertNotNull(item.getId());
        Assertions.assertNotNull(item.getName());
        Assertions.assertNotNull(item.getDescription());
        Assertions.assertNotNull(item.getPrice());
        Assertions.assertNotNull(item.getCategory());
        Assertions.assertNotNull(item.getCountries());

        Assertions.assertEquals(dto.getId(), item.getId());
        Assertions.assertEquals(dto.getNameDto(), item.getName());
        Assertions.assertEquals(dto.getDescriptionDto(), item.getDescription());
        Assertions.assertEquals(dto.getPriceDto(), item.getPrice());
        Assertions.assertEquals(dto.getCategoryDto(), item.getCategory());
        Assertions.assertEquals(dto.getCountriesDto(), item.getCountries());
    }




    @Test
    void convertEntityListToDtoListTest() {
        List<Item> items = new ArrayList<>();

        for (long i = 1; i <= 3; i++) {
            Item item = new Item();
            item.setId(i);
            item.setName("Item" + i);
            item.setDescription("Desc" + i);
            item.setPrice((int) (1000 * i));
            items.add(item);
        }

        List<ItemDto> dtos = itemMapper.toDtoList(items);

        Assertions.assertNotNull(dtos);
        Assertions.assertNotEquals(0, dtos.size());
        Assertions.assertEquals(items.size(), dtos.size());

        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            ItemDto dto = dtos.get(i);

            Assertions.assertNotNull(dto);
            Assertions.assertNotNull(dto.getId());
            Assertions.assertNotNull(dto.getNameDto());
            Assertions.assertNotNull(dto.getDescriptionDto());

            Assertions.assertEquals(item.getId(), dto.getId());
            Assertions.assertEquals(item.getName(), dto.getNameDto());
            Assertions.assertEquals(item.getDescription(), dto.getDescriptionDto());
            Assertions.assertEquals(item.getPrice(), dto.getPriceDto());
        }
    }
}
}
