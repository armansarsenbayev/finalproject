package com.example.endterm.midterm1.mapper;

import com.example.endterm.midterm1.dto.CountryDto;
import com.example.endterm.midterm1.entity.Country;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CountryMapper {

    @Mapping(target = "codeDto", source = "code")
    @Mapping(target = "countryDto", source = "country")
    CountryDto toDto(Country country);

    @Mapping(target = "code", source = "codeDto")
    @Mapping(target = "country", source = "countryDto")
    Country toEntity(CountryDto dto);

    List<CountryDto> toDtoList(List<Country> countries);
}
