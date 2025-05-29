package com.RAGA.quizApplecation.service;

import com.RAGA.quizApplecation.entity.QuestionEntity;
import com.RAGA.quizApplecation.entity.QuestionWrapperEntity;
import com.RAGA.quizApplecation.entity.QuizEntity;
import com.RAGA.quizApplecation.entity.Response;
import com.RAGA.quizApplecation.repository.QuestionJPA;
import com.RAGA.quizApplecation.repository.QuizJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    private QuizJPA quizJPA;
    @Autowired
    private QuestionJPA questionJPA;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<QuestionEntity> questions = questionJPA.findRandomQuetionByCategory(category, numQ);
        QuizEntity quiz = new QuizEntity();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizJPA.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<String> deleteById(int id) {
        quizJPA.deleteById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.ACCEPTED);
    }

    public ResponseEntity<List<QuizEntity>> getAllQuiz() {
        return new ResponseEntity<>(quizJPA.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapperEntity>> getQuestionsById(int id) {
        Optional<QuizEntity> quiz = quizJPA.findById(id);
        List<QuestionEntity> questions = quiz.get().getQuestions();
        List<QuestionWrapperEntity> questionsForUser = new ArrayList<>();
        for(QuestionEntity q:questions){
            QuestionWrapperEntity questionWrapper = new QuestionWrapperEntity(q.getId(), q.getQuestion(), q.getOption01(), q.getOption02(), q.getOption03(), q.getOption04());
            questionsForUser.add(questionWrapper);
        }
        return new ResponseEntity<>(questionsForUser, HttpStatus.OK);
    }

    public ResponseEntity<Integer> getYourScore(int id, List<Response> response) {
        int cnt = 0;
        QuizEntity quiz = quizJPA.findById(id).get();
        List<QuestionEntity> questionEntities = quiz.getQuestions();
        int idx = 0;
        for(Response res:response){
            if(res.getResponse().equals(questionEntities.get(idx).getAnswer()))cnt++;
            idx++;
        }
        return new ResponseEntity<>(cnt, HttpStatus.OK);
    }
}
