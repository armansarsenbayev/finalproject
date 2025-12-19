package com.example.endterm.midterm1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemDto {
    private Long id;
    private String nameDto;
    private String descriptionDto;
    private int priceDto;

    private CategoryDto categoryDto;
    private List<CountryDto> countriesDto;
}
