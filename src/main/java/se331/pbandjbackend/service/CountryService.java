package se331.pbandjbackend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.pbandjbackend.entity.Country;

public interface CountryService {
    Integer getCountrySize();
    Page<Country> getCountries(Integer pageSize, Integer page);
    Country getCountry(Long id);
    Country save(Country country);
    Page<Country> getCountries(String title, Pageable page);
}
