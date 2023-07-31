package tpSpringBoot.TPQuiz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tpSpringBoot.TPQuiz.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

    List<Question>findByCategory(String category);

}
