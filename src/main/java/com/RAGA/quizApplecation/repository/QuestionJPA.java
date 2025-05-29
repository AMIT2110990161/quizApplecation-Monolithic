package com.RAGA.quizApplecation.repository;

import com.RAGA.quizApplecation.entity.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionJPA extends JpaRepository<QuestionEntity, Integer> {
    List<QuestionEntity> findByCategory(String category);

    List<QuestionEntity> findByDifficultyLevel(String difficultyLevel);

    List<QuestionEntity> findByCategoryAndDifficultyLevel(String category, String difficultyLevel);

    @Query(value = "SELECT * FROM question_entity WHERE category = :category ORDER BY RAND() LIMIT :numQ", nativeQuery = true)
    List<QuestionEntity> findRandomQuetionByCategory(String category, int numQ);
}
