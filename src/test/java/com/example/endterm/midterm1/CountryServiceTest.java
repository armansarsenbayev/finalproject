package com.example.endterm.midterm1;

import com.example.endterm.midterm1.dto.CountryDto;
import com.example.endterm.midterm1.service.CountryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Random;

@SpringBootTest
@ActiveProfiles("test")
public class CountryServiceTest {

    @Autowired
    private CountryService countryService;

    @Test
    void getAllTest() {
        List<CountryDto> dtos = countryService.getAll();

        Assertions.assertNotNull(dtos);
        Assertions.assertNotEquals(0, dtos.size());

        for (int i = 0; i < dtos.size(); i++) {
            CountryDto dto = dtos.get(i);

            Assertions.assertNotNull(dto);
            Assertions.assertNotNull(dto.getId());
            Assertions.assertNotNull(dto.getCodeDto());
            Assertions.assertNotNull(dto.getCountryDto());
        }
    }

    @Test
    void getByIdTest() {
        Random random = new Random();

        int randomIndex = random.nextInt(countryService.getAll().size());
        Long someId = countryService.getAll().get(randomIndex).getId();

        CountryDto dto = countryService.getById(someId);

        Assertions.assertNotNull(dto);
        Assertions.assertNotNull(dto.getId());
        Assertions.assertNotNull(dto.getCodeDto());
        Assertions.assertNotNull(dto.getCountryDto());

        CountryDto check = countryService.getById(-1L);
        Assertions.assertNull(check);
    }

    @Test
    void addTest() {
        CountryDto dto = CountryDto.builder()
                .codeDto("CA")
                .countryDto("Canada")
                .build();

        CountryDto added = countryService.addCountry(dto);

        Assertions.assertNotNull(added);
        Assertions.assertNotNull(added.getId());
        Assertions.assertNotNull(added.getCodeDto());
        Assertions.assertNotNull(added.getCountryDto());

        CountryDto fromDb = countryService.getById(added.getId());

        Assertions.assertNotNull(fromDb);
        Assertions.assertEquals(added.getId(), fromDb.getId());
        Assertions.assertEquals(added.getCodeDto(), fromDb.getCodeDto());
        Assertions.assertEquals(added.getCountryDto(), fromDb.getCountryDto());
    }

    @Test
    void updateTest() {
        Random random = new Random();
        int randomIndex = random.nextInt(countryService.getAll().size());
        Long someId = countryService.getAll().get(randomIndex).getId();

        CountryDto newDto = CountryDto.builder()
                .id(someId)
                .codeDto("RU")
                .countryDto("Russia")
                .build();

        CountryDto updated = countryService.updateById(someId, newDto);

        Assertions.assertNotNull(updated);
        Assertions.assertEquals(someId, updated.getId());
        Assertions.assertEquals("RU", updated.getCodeDto());
        Assertions.assertEquals("Russia", updated.getCountryDto());

        CountryDto check = countryService.getById(someId);
        Assertions.assertNotNull(check);
        Assertions.assertEquals(updated.getId(), check.getId());
        Assertions.assertEquals(updated.getCodeDto(), check.getCodeDto());
        Assertions.assertEquals(updated.getCountryDto(), check.getCountryDto());
    }

    @Test
    void deleteTest() {
        Random random = new Random();
        int randomIndex = random.nextInt(countryService.getAll().size());
        Long someId = countryService.getAll().get(randomIndex).getId();

        Assertions.assertTrue(countryService.deleteById(someId));

        CountryDto deleted = countryService.getById(someId);
        Assertions.assertNull(deleted);
    }
}
