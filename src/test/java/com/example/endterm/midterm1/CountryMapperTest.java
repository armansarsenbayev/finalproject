package com.example.endterm.midterm1;

import com.example.endterm.midterm1.dto.CategoryDto;
import com.example.endterm.midterm1.dto.CountryDto;
import com.example.endterm.midterm1.entity.Country;
import com.example.endterm.midterm1.mapper.CategoryMapper;
import com.example.endterm.midterm1.mapper.CountryMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;


public class CountryMapperTest {

    private final CountryMapper countryMapper = Mappers.getMapper(CountryMapper.class);

    @Test
    void toDtoTest(){
        Country country = new Country();
        country.setId(3L);
        country.setCode("KZ");
        country.setCountry("Kazakhstan");

        CountryDto dto = countryMapper.toDto(country);

        Assertions.assertNotNull(dto);
        Assertions.assertEquals(3L, dto.getId());
        Assertions.assertEquals("KZ", dto.getCodeDto());
        Assertions.assertEquals("Kazakhstan", dto.getCountryDto());

    }

    @Test
    void toEntityTest(){
        CountryDto dto = CountryDto.builder()
                .id(4L)
                .codeDto("JP")
                .countryDto("Japan")
                .build();

        Country entity = countryMapper.toEntity(dto);

        Assertions.assertNotNull(entity);
        Assertions.assertEquals(4L, entity.getId());
        Assertions.assertEquals("JP", entity.getCode());
        Assertions.assertEquals("Japan", entity.getCountry());

    }
}
