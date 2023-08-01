package tpSpringBoot.TPQuiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tpSpringBoot.TPQuiz.model.Question;
import tpSpringBoot.TPQuiz.model.User;
import tpSpringBoot.TPQuiz.repository.UserRepository;

@RestController
@RequestMapping("participer")
public class ParticipationController {
    

     @Autowired
     UserRepository userRepository;

    // verification des comptes
      @PostMapping("/connexion")
     public ResponseEntity<String> seConnecter(@RequestBody User user ) {
        // Récupérer les informations d'authentification du LoginRequest
        String pseudo = user.getPseudo();

        String passwords = user.getMdp();

        // Rechercher l'inscription par nom d'utilisateur dans la base de données
        User user2 = userRepository.findByNom(pseudo);

        // Vérifier si l'inscription existe et si le mot de passe est correct
        if (user != null && user.getMdp().equals(passwords)) {
            return new ResponseEntity<>("Connexion réussie !", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Nom d'utilisateur ou mot de passe incorrect.", HttpStatus.UNAUTHORIZED);
        }
    }



}   

