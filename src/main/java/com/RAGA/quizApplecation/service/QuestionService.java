package com.RAGA.quizApplecation.service;

import com.RAGA.quizApplecation.entity.QuestionEntity;
import com.RAGA.quizApplecation.repository.QuestionJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionJPA questionJPA;

    public ResponseEntity<List<QuestionEntity>> getAllQuestion(){
        try{
            return new ResponseEntity<>(questionJPA.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<QuestionEntity> postQuestion(QuestionEntity question){
        try{
            return new ResponseEntity<>(questionJPA.save(question), HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> deleteAll() {
        try{
            questionJPA.deleteAll();
            return new ResponseEntity<>("Deleted entire data", HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Nothing has been done", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<QuestionEntity>> getByCategory(String category) {
        try{
            return new ResponseEntity<>(questionJPA.findByCategory(category), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<QuestionEntity>> getByDifficultyLevel(String difficultyLevel) {
        try{
            return new ResponseEntity<>(questionJPA.findByDifficultyLevel(difficultyLevel), HttpStatus.OK);
        }  catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<QuestionEntity>> getByCategoryDifficulty(String category, String difficultyLevel) {
        try{
            return new ResponseEntity<>(questionJPA.findByCategoryAndDifficultyLevel(category, difficultyLevel), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }
}
