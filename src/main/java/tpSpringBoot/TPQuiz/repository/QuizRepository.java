package tpSpringBoot.TPQuiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tpSpringBoot.TPQuiz.model.Quiz;

public interface QuizRepository extends JpaRepository<Quiz,Integer>{
    
}
