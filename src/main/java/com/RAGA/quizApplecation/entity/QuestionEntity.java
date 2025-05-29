package com.RAGA.quizApplecation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class QuestionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String category;
    private String difficultyLevel;
    private String question;
    private String option01;
    private String option02;
    private String option03;
    private String option04;
    private String answer;
}
