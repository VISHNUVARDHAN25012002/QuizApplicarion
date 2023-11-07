package com.Springapp.Quizapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="quiz_questions")
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
	String question;
	String option1;
	String option2;
	String option3;
	String option4;
	Integer correctOption;
	String  difficultyLevel;
	String category;
	

}
