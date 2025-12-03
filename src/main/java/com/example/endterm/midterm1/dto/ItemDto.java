package com.example.endterm.midterm1.dto;


import lombok.*;
import com.example.endterm.midterm1.entity.Category;
import com.example.endterm.midterm1.entity.Country;

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

    private Category categoryDto;

    private List<Country> countriesDto;

}
