package com.example.endterm.midterm1.service;

import com.example.endterm.midterm1.dto.CountryDto;

import java.util.List;

public interface CountryService {
    List<CountryDto> getAll();
    CountryDto getById(Long id);
    void addCountry(CountryDto itemDto);
    CountryDto updateById(Long id, CountryDto itemDto);
    boolean deleteById(Long id);
}
