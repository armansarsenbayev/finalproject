package com.example.endterm.midterm1.service.impl;

import lombok.RequiredArgsConstructor;
import com.example.endterm.midterm1.dto.CountryDto;
import com.example.endterm.midterm1.entity.Country;
import com.example.endterm.midterm1.mapper.CountryMapper;
import com.example.endterm.midterm1.repository.CountryRepository;
import com.example.endterm.midterm1.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;

    @Override
    public List<CountryDto> getAll() {
        return countryMapper.toDtoList(countryRepository.findAll());
    }

    @Override
    public CountryDto getById(Long id) {
        return countryRepository.findById(id)
                .map(countryMapper::toDto)
                .orElse(null);
    }


    @Override
    public void addCountry(CountryDto countryDto) {
        countryRepository.save(countryMapper.toEntity(countryDto));
    }

    @Override
    public CountryDto updateById(Long id, CountryDto countryDto) {
        Country country = countryMapper.toEntity(countryDto);

        Country updateCountry = countryRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Not found"));

        updateCountry.setCode(country.getCode());
        updateCountry.setCountry(country.getCountry());

        return countryMapper.toDto(countryRepository.save(updateCountry));
    }

    @Override
    public boolean deleteById(Long id) {
        countryRepository.deleteById(id);
        return true;
    }
}
