package se331.pbandjbackend.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.pbandjbackend.entity.Country;

public interface CountryDao {
    Integer getCountrySize();
    Page<Country> getCountries(Integer pageSize, Integer page);
    Country getCountry(Long id);
    Country save(Country country);
    Page<Country> getCountries(String title, Pageable page);
}
