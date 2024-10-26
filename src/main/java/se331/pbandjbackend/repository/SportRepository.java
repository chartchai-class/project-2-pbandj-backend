package se331.pbandjbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se331.pbandjbackend.entity.Sport;

public interface SportRepository extends JpaRepository<Sport, Long> {

}
