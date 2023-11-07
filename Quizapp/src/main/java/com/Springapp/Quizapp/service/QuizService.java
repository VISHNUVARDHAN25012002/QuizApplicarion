package com.Springapp.Quizapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Springapp.Quizapp.dao.QuestionDao;
import com.Springapp.Quizapp.dao.QuizDao;
import com.Springapp.Quizapp.model.Question;
import com.Springapp.Quizapp.model.QuestionWrapper;
import com.Springapp.Quizapp.model.Quiz;
	
	@Service
	public class QuizService {
	@Autowired
	QuizDao quizDao;

	@Autowired
	QuestionDao questionDao;

	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
		List<Question> questions = questionDao.findRandomQuestionByCategory(category, numQ);

		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestion(questions);
		quizDao.save(quiz);

		return new ResponseEntity<>("Success", HttpStatus.CREATED);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
		Optional<Quiz> quiz=quizDao.findById(id);
		List<Question> questionFromDB=quiz.get().getQuestion();
		List<QuestionWrapper> questionForUser=new ArrayList<>();
		for(Question q: questionFromDB) {
			QuestionWrapper qw=new QuestionWrapper(q.getId(),q.getQuestion(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
			questionForUser.add(qw);
		}
		return new ResponseEntity<>(questionForUser,HttpStatus.OK);
		
	}

	@SuppressWarnings("unlikely-arg-type")
	public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
	    Quiz quiz = quizDao.findById(id).get();
	    List<Question> questions = quiz.getQuestion();
	    int right = 0;
	    int i = 0;
	    for (Response response : responses) {
	        if (response.getResponse().equals(questions.get(i).getCorrectOption())) {
	            right++;
	        }
	        i++;
	    }
	    return new ResponseEntity<>(right, HttpStatus.OK);
	}


}
