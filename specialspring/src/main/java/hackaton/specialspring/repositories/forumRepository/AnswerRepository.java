package hackaton.specialspring.repositories.forumRepository;
import hackaton.specialspring.entities.Specialities;
import hackaton.specialspring.entities.forum.Answers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface AnswerRepository extends JpaRepository<Answers, Long> {

}