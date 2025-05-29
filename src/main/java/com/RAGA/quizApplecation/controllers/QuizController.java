package com.RAGA.quizApplecation.controllers;

import com.RAGA.quizApplecation.entity.QuestionEntity;
import com.RAGA.quizApplecation.entity.QuestionWrapperEntity;
import com.RAGA.quizApplecation.entity.QuizEntity;
import com.RAGA.quizApplecation.entity.Response;
import com.RAGA.quizApplecation.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @GetMapping()
    public ResponseEntity<List<QuizEntity>> getAllQuiz(){
        return quizService.getAllQuiz();
    }

    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title){
        return quizService.createQuiz(category, numQ, title);
    }

    @DeleteMapping("id/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id){
        return quizService.deleteById(id);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapperEntity>> getQuestionsById(@PathVariable int id){
        return quizService.getQuestionsById(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> getYourScore(@PathVariable int id, @RequestBody List<Response> response){
        return quizService.getYourScore(id, response);
    }
}
