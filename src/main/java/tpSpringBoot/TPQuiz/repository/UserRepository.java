package tpSpringBoot.TPQuiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tpSpringBoot.TPQuiz.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    
    User findByPseudo(String pseudo);
}
