package se331.pbandjbackend.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.pbandjbackend.entity.Country;
import se331.pbandjbackend.entity.Sport;
import se331.pbandjbackend.repository.SportRepository;

public interface SportDao {
    Integer getSportSize();
    Page<Sport> getSports(Integer pageSize, Integer page);
    Sport getSport(Long id);
    Sport save(Sport sport);
    Page<Sport> getSports(String title, Pageable page);
}
