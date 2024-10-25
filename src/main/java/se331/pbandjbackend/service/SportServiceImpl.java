package se331.pbandjbackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import se331.pbandjbackend.dao.SportDao;
import se331.pbandjbackend.entity.Sport;

@Service
@RequiredArgsConstructor
public class SportServiceImpl implements SportService{
    final SportDao sportDao;
    @Override
    public Integer getSportSize() {
        return sportDao.getSportSize();
    }

    @Override
    public Page<Sport> getSports(Integer pageSize, Integer page) {
        return sportDao.getSports(pageSize, page);
    }

    @Override
    public Sport getSport(Long id) {
        return sportDao.getSport(id);
    }

    @Override
    public Sport save(Sport sport) {
        return sportDao.save(sport);
    }

    @Override
    public Page<Sport> getSports(String title, Pageable page) {
        return sportDao.getSports(title, page);
    }
}
