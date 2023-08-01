package tpSpringBoot.TPQuiz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import tpSpringBoot.TPQuiz.model.Quiz;

public interface QuizRepository extends JpaRepository<Quiz,Integer>{
 
     List<Quiz>findByCategory(String category);
}
