package hackaton.specialspring.repositories.forumRepository;

import hackaton.specialspring.entities.forum.Questions;
import hackaton.specialspring.entities.Specialities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public interface QuestionRepository extends JpaRepository<Questions, Long> {

}