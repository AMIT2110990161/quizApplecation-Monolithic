package com.RAGA.quizApplecation.repository;

import com.RAGA.quizApplecation.entity.QuizEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizJPA extends JpaRepository<QuizEntity, Integer> {
}
