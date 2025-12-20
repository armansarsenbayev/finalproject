package com.example.endterm.midterm1.controller;

import com.example.endterm.midterm1.dto.CountryDto;
import com.example.endterm.midterm1.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/country")
public class CountryApi {

    private final CountryService countryService;

    @GetMapping
    public List<CountryDto> getAll() {
        return countryService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CountryDto> getById(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(countryService.getById(id));
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> add(@RequestBody CountryDto countryDto) {
        countryService.addCountry(countryDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CountryDto> update(@PathVariable("id") Long id, @RequestBody CountryDto countryDto) {
        try {
            return ResponseEntity.ok(countryService.updateById(id, countryDto));
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        countryService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
