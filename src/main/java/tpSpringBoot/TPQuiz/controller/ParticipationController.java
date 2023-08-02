package tpSpringBoot.TPQuiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tpSpringBoot.TPQuiz.model.Participation;
// import tpSpringBoot.TPQuiz.model.Question;
// import tpSpringBoot.TPQuiz.model.Quiz;
import tpSpringBoot.TPQuiz.model.Reponse;
import tpSpringBoot.TPQuiz.model.User;
import tpSpringBoot.TPQuiz.repository.UserRepository;
import tpSpringBoot.TPQuiz.service.ParticipationService;
import tpSpringBoot.TPQuiz.service.QuizService;
import tpSpringBoot.TPQuiz.service.UserService;

@RestController
@RequestMapping("/participer")
public class ParticipationController {

    // private QuizService quizService;

    @Autowired
    ParticipationService participationService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Autowired
    QuizService quizService;

    @Autowired
    public ParticipationController(QuizService quizService, ParticipationService participationService) {
        this.quizService = quizService;
        this.participationService = participationService;
    }

  
   
    //Constructeur pour verifier les donnees du user
    public ParticipationController(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    @PostMapping("/participer/{IdQz}")
    public ResponseEntity<Integer> participer(@PathVariable Integer IdQz, @RequestBody List<Reponse> reponses) {
        return participationService.calculateResult(IdQz, reponses);
    }

    @PostMapping("/connexion")
    public ResponseEntity<String> seConnecter(@RequestBody User user) {
        // Récupérer les informations d'authentification du LoginRequest
        String pseudo = user.getPseudo();

        String passwords = user.getMdp();

        // Rechercher l'inscription par nom d'utilisateur dans la base de données
        User u = userRepository.findByPseudo(pseudo);

        // Vérifier si l'inscription existe et si le mot de passe est correct
        if (u != null && u.getMdp().equals(passwords)) {
            return new ResponseEntity<>("Connexion réussie !", HttpStatus.OK);

        } else {
            return new ResponseEntity<>("Nom d'utilisateur ou mot de passe incorrect.", HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Participation>> getAllParticipation() {
        return participationService.getAllParticipation();
    }

}
