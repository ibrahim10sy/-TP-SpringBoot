package tpSpringBoot.TPQuiz.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import tpSpringBoot.TPQuiz.model.Question;
import tpSpringBoot.TPQuiz.model.User;
import tpSpringBoot.TPQuiz.repository.UserRepository;

@Service
public class UserService {

      @Autowired
      UserRepository userRepository;

    public ResponseEntity<String> addUser(User user){
        userRepository.save(user);
        return new ResponseEntity<>("Ajouter avec succèss", HttpStatus.CREATED);
    }


    //Liste des users
    public ResponseEntity <List<User>> getAllUser() {
        try {
            return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
             e.printStackTrace();
        }
       return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }
    
    
}
