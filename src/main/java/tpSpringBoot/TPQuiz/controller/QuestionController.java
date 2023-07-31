package tpSpringBoot.TPQuiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tpSpringBoot.TPQuiz.model.Question;
import tpSpringBoot.TPQuiz.service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {
    
    @Autowired
    QuestionService questionService;

    //Ajouter 
    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }
    //Liste
    @GetMapping("allquestion")
    public ResponseEntity<List<Question>>getAllQuestion(){
        return questionService.getAllQuestion();
    }

    //Recherche par categorie
     @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category) {
        return questionService.getQuestionByCategory(category);
    }
    //Suppression
    @DeleteMapping("question/{idQ}")
    public String Question(@PathVariable Integer idQ, @RequestBody Question question ){
        return questionService.SupprimerQuestions(idQ, question);
    }
}
