package se331.pbandjbackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import se331.pbandjbackend.dao.CountryDao;
import se331.pbandjbackend.entity.Country;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService{
    final CountryDao countryDao;
    @Override
    public Integer getCountrySize() {
        return countryDao.getCountrySize();
    }

    @Override
    public Page<Country> getCountries(Integer pageSize, Integer page) {
        return countryDao.getCountries(pageSize, page);
    }

    @Override
    public Country getCountry(Long id) {
        return countryDao.getCountry(id);
    }

    @Override
    public Country save(Country country) {
        return countryDao.save(country);
    }

    @Override
    public Page<Country> getCountries(String title, Pageable page) {
        return countryDao.getCountries(title, page);
    }
}
