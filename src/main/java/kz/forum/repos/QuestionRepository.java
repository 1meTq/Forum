package kz.forum.repos;

import kz.forum.models.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface QuestionRepository extends JpaRepository<Questions, Long> {
}
