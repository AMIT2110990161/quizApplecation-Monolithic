package com.RAGA.quizApplecation.controllers;


import com.RAGA.quizApplecation.entity.QuestionEntity;
import com.RAGA.quizApplecation.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping()
    public ResponseEntity<List<QuestionEntity>> getAllQuestion(){
        return questionService.getAllQuestion();
    }

    @PostMapping()
    public ResponseEntity<QuestionEntity> postQuestion(@RequestBody QuestionEntity question){
        return questionService.postQuestion(question);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteAll(){
        return questionService.deleteAll();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<QuestionEntity>> getByCategory(@PathVariable String category){
        return questionService.getByCategory(category);
    }

    @GetMapping("level/{difficultyLevel}")
    public ResponseEntity<List<QuestionEntity>> getByDifficultyLevel(@PathVariable String difficultyLevel){
        return questionService.getByDifficultyLevel(difficultyLevel);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<QuestionEntity>> getByCategoryDifficulty(@RequestParam String category, @RequestParam String difficultyLevel){
        return questionService.getByCategoryDifficulty(category, difficultyLevel);
    }
}
