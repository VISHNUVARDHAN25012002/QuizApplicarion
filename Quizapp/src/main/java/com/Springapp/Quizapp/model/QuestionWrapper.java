package com.Springapp.Quizapp.model;

import lombok.Data;

@Data
public class QuestionWrapper {
	Integer id;
	String question;
	String option1;
	String option2;
	String option3;
	String option4;
	public QuestionWrapper(Integer id, String question, String option1, String option2, String option3,
			String option4) {
		super();
		this.id = id;
		this.question = question;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
	}
}
