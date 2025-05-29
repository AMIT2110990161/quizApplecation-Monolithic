package com.RAGA.quizApplecation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class QuestionWrapperEntity {
    private int id;
    private String question;
    private String option01;
    private String option02;
    private String option03;
    private String option04;
}
