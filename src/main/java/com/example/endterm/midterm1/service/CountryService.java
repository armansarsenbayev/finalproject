package com.example.endterm.midterm1.service;

import com.example.endterm.midterm1.dto.CountryDto;

import java.util.List;

public interface CountryService {
    List<CountryDto> getAll();
    CountryDto getById(Long id);
    CountryDto addCountry(CountryDto countryDto);
    CountryDto updateById(Long id, CountryDto countryDto);
    boolean deleteById(Long id);
}
