package com.example.endterm.midterm1.service.impl;

import com.example.endterm.midterm1.dto.CountryDto;
import com.example.endterm.midterm1.entity.Country;
import com.example.endterm.midterm1.mapper.CountryMapper;
import com.example.endterm.midterm1.repository.CountryRepository;
import com.example.endterm.midterm1.service.CountryService;
import lombok.RequiredArgsConstructor;
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
        return countryMapper.toDto(countryRepository.findById(id).orElse(null));
    }

    @Override
    public CountryDto addCountry(CountryDto countryDto) {
        Country saved = countryRepository.save(countryMapper.toEntity(countryDto));
        return countryMapper.toDto(saved);
    }

    @Override
    public CountryDto updateById(Long id, CountryDto countryDto) {
        Country existing = countryRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Not found"));

        Country incoming = countryMapper.toEntity(countryDto);

        existing.setCode(incoming.getCode());
        existing.setCountry(incoming.getCountry());

        Country saved = countryRepository.save(existing);
        return countryMapper.toDto(saved);
    }

    @Override
    public boolean deleteById(Long id) {
        if (!countryRepository.existsById(id)) return false;
        countryRepository.deleteById(id);
        return true;
    }
}
