package hackaton.specialspring.repositories;

import hackaton.specialspring.entities.Sections;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public interface SectionsRepository extends JpaRepository<Sections, Long> {

    List<Sections> findAll();
    Sections findById(long id);

}