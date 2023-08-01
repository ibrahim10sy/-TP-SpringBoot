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

import tpSpringBoot.TPQuiz.model.Participation;
import tpSpringBoot.TPQuiz.model.Question;
import tpSpringBoot.TPQuiz.model.Quiz;
import tpSpringBoot.TPQuiz.service.QuestionService;
import tpSpringBoot.TPQuiz.service.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    QuestionService questionService;

    @Autowired
    QuizService quizService;


    @PostMapping("add")
    public ResponseEntity<String> addQuiz(@RequestBody Quiz quiz){
        return quizService.CreateQuiz(quiz);
    }    

     @GetMapping("category/{category}")
    public ResponseEntity<List<Quiz>> getQuizByCategory(@PathVariable String category) {
        return quizService.getQuizByCategory(category);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Quiz>> getAllQuiz() {
        return quizService.getAllQuiz();
    }

    //Suppression
    @DeleteMapping("quiz/{idQz}")
    public String Quiz(@PathVariable Integer idQz, @RequestBody Quiz quiz ){
        return quizService.SupprimerQuiz(idQz, quiz);
    }
    

}
