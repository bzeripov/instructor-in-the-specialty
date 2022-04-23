package hackaton.specialspring.repositories;

import hackaton.specialspring.entities.Albums;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface AlbumRepository extends JpaRepository<Albums, Long> {
    Albums findById(long id);
}
