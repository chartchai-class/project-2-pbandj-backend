package se331.pbandjbackend.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import se331.pbandjbackend.entity.Country;
import se331.pbandjbackend.repository.CountryRepository;

@Repository
@RequiredArgsConstructor
public class CountryDaoImpl implements CountryDao {
    final CountryRepository countryRepository;
    @Override
    public Integer getCountrySize() {
        return Math.toIntExact (countryRepository.count());
    }

    @Override
    public Page<Country> getCountries(Integer pageSize, Integer page) {
        pageSize = pageSize == null ? getCountrySize() : pageSize;
        page = page == null ? 1 : page;
        return countryRepository.findAll(PageRequest.of(page - 1, pageSize));
    }

    @Override
    public Country getCountry(Long id) {
        return countryRepository.findById(id).orElse(null);
    }

    @Override
    public Country save(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public Page<Country> getCountries(String title, Pageable page) {
        return null;
    }
}
