package tpSpringBoot.TPQuiz.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import tpSpringBoot.TPQuiz.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{
    
    //    Admin findAdminByName(String nom);
}
