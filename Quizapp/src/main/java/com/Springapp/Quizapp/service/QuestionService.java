package com.Springapp.Quizapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Springapp.Quizapp.dao.QuestionDao;
import com.Springapp.Quizapp.model.Question;

@Service
public class QuestionService {
	
	@Autowired
	QuestionDao questionDao;

	public ResponseEntity<List<Question>> getAllQuestions() {
		try {
			return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(new ArrayList(), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<List<Question>> getQuestionsBycategory(String category) {
		try {
			return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList(), HttpStatus.BAD_REQUEST);

	}

	public ResponseEntity<String> addQuestions(Question question) {
		questionDao.save(question);
		return new ResponseEntity<>("Success", HttpStatus.CREATED);

	}

	public String removeQuestion(int id) {
		questionDao.deleteById(id);
		return "Removed Succesfully";

	}

}
