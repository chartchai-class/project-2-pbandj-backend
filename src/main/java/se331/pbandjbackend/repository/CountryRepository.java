package se331.pbandjbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se331.pbandjbackend.entity.Country;

public interface CountryRepository extends JpaRepository <Country, Long> {

}
