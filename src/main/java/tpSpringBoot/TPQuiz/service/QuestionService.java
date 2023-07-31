package tpSpringBoot.TPQuiz.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import tpSpringBoot.TPQuiz.model.Question;
import tpSpringBoot.TPQuiz.repository.QuestionRepository;

@Service
public class QuestionService {
    
    @Autowired
    QuestionRepository questionRepository;

    //Méthode permettant d'ajouter des questions
    public ResponseEntity<String> addQuestion(Question question){
        questionRepository.save(question);
        return new ResponseEntity<>("Ajouter avec succèss", HttpStatus.CREATED);
    }

    //Rechercher par categorie
    
    public ResponseEntity<List<Question>>getQuestionByCategory(String category){
      try {
         return new ResponseEntity<>( questionRepository.findByCategory(category), HttpStatus.OK);
      } catch (Exception e) {
        e.printStackTrace();
      }

      return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    //Supprimer des questions
    public String SupprimerQuestions(Integer idQ, Question question){
        questionRepository.deleteById(idQ);
        return "Supprimer avec succèss";
    }

    //Liste des questions
    public ResponseEntity <List<Question>> getAllQuestion() {
        try {
            return new ResponseEntity<>(questionRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
             e.printStackTrace();
        }
       return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }
}
