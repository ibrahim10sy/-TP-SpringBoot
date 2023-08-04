package tpSpringBoot.TPQuiz.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import tpSpringBoot.TPQuiz.model.Admin;
import tpSpringBoot.TPQuiz.model.User;
import tpSpringBoot.TPQuiz.repository.AdminRepository;

@Service
public class AdminService {


    @Autowired
    private AdminRepository adminRepository;

    public ResponseEntity<String> addAdmin(Admin admin){
        adminRepository.save(admin);
        return new ResponseEntity<>("Créer avec succèss", HttpStatus.CREATED);
    }

    //Liste des users
    public ResponseEntity <List<Admin>> getAllAdmin() {
        try {
            return new ResponseEntity<>(adminRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
             e.printStackTrace();
        }
       return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }
    
}


