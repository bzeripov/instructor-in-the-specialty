package hackaton.specialspring.repositories;

import hackaton.specialspring.entities.Sections;
import hackaton.specialspring.entities.Specialities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface SpecialityRepository extends JpaRepository<Specialities, Long> {
    List<Specialities> findAllBySectionEquals(long id);
    Specialities findById(long id);
}