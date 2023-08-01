package tpSpringBoot.TPQuiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tpSpringBoot.TPQuiz.model.Question;
import tpSpringBoot.TPQuiz.model.User;
import tpSpringBoot.TPQuiz.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    UserService userService;

   @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody User user){
        return userService.addUser(user);
    }
   
    //Liste
    @GetMapping("all")
    public ResponseEntity<List<User>>getAllQuestion(){
        return userService.getAllUser();
    }
    
}
