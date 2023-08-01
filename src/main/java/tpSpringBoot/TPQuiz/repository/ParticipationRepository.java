package tpSpringBoot.TPQuiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tpSpringBoot.TPQuiz.model.Participation;

public interface ParticipationRepository extends JpaRepository<Participation, Integer>{
    
}
