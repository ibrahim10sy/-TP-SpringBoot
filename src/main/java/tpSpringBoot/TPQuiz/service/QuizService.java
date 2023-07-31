package tpSpringBoot.TPQuiz.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import tpSpringBoot.TPQuiz.model.Question;
import tpSpringBoot.TPQuiz.model.Quiz;
import tpSpringBoot.TPQuiz.model.Reponse;
import tpSpringBoot.TPQuiz.repository.QuestionRepository;
import tpSpringBoot.TPQuiz.repository.QuizRepository;

@Service
public class QuizService {
    
    @Autowired
    QuizRepository quizRepository;
    @Autowired
    QuestionRepository questionRepository;

    //Création de quiz
     public ResponseEntity<String> CreateQuiz(Quiz quiz){
        quizRepository.save(quiz);
        return new ResponseEntity<>("Créer avec succèss", HttpStatus.CREATED);
    }

    public ResponseEntity<Integer>CalculerResultat(Integer idR,List<Reponse> reponses){
        
        Quiz quiz = quizRepository.findById(idR).get();
        List<Question> question = quiz.getQuestion();
        int score = 0;
        int i = 0;
        for(Reponse reponse : reponses){
            if (reponses.get(i).getVraiReponse() == true){
                score++;
            }
            i++;
        }
        return new ResponseEntity<>(score, HttpStatus.OK);
    }

}
