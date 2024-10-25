package se331.pbandjbackend.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import se331.pbandjbackend.entity.Country;
import se331.pbandjbackend.entity.Sport;
import se331.pbandjbackend.repository.SportRepository;

@Repository
@RequiredArgsConstructor
public class SportDaoImpl implements SportDao{
    final SportRepository sportRepository;
    @Override
    public Integer getSportSize() {
        return Math.toIntExact(sportRepository.count());
    }

    @Override
    public Page<Sport> getSports(Integer pageSize, Integer page) {
        pageSize = pageSize == null ? getSportSize() : pageSize;
        page = page == null ? 1 : page;
        return sportRepository.findAll(PageRequest.of(page - 1, pageSize));
    }

    @Override
    public Sport getSport(Long id) {
        return sportRepository.findById(id).orElse(null);
    }

    @Override
    public Sport save(Sport sport) {
        return sportRepository.save(sport);
    }

    @Override
    public Page<Sport> getSports(String title, Pageable page) {
        return null;
    }
}
