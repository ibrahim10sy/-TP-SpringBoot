package tpSpringBoot.TPQuiz.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import tpSpringBoot.TPQuiz.model.Participation;
import tpSpringBoot.TPQuiz.model.Question;
import tpSpringBoot.TPQuiz.model.Quiz;
import tpSpringBoot.TPQuiz.model.Reponse;
import tpSpringBoot.TPQuiz.repository.ParticipationRepository;
import tpSpringBoot.TPQuiz.repository.QuestionRepository;
import tpSpringBoot.TPQuiz.repository.QuizRepository;


@Service
public class ParticipationService {

 
   @Autowired
   ParticipationRepository participationRepository;

   @Autowired
   QuizRepository quizRepository;

   @Autowired
   QuestionRepository questionRepository;

    //Liste des participations
  


    //Calculer resultat
    public ResponseEntity<Integer> calculateResult(Integer id, List<Reponse> reponses) {
        Quiz quiz = quizRepository.findById(id).orElse(null);
        if (quiz == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    
        List<Question> questions = quiz.getQuestion();
        if (questions.size() != reponses.size()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    
        int score = 0;
        for (int i = 0; i < questions.size(); i++) {
            // Question question = questions.get(i);
            Reponse reponseUtilisateur = reponses.get(i);
    
            // Vérifier si la réponse de l'utilisateur est correcte
            // if (reponseUtilisateur.getVraiReponse() && reponseUtilisateur.getOptionR()==true ) {
            //     score++;
            // }
            if(reponseUtilisateur.getOptionR().equals(reponseUtilisateur.getVraiReponse().toString()))
            score++;
        }
     
        return new ResponseEntity<>(score, HttpStatus.OK);
    }
    
 //Liste des participations
    public ResponseEntity <List<Participation>> getAllParticipation() {
        try {
            return new ResponseEntity<>(participationRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
             e.printStackTrace();
        }
       return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }
    
}
