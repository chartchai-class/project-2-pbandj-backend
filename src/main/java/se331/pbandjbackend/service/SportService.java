package se331.pbandjbackend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.pbandjbackend.entity.Sport;

public interface SportService {
    Integer getSportSize();
    Page<Sport> getSports(Integer pageSize, Integer page);
    Sport getSport(Long id);
    Sport save(Sport sport);
    Page<Sport> getSports(String title, Pageable page);
}
