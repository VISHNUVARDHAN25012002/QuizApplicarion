package com.Springapp.Quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Springapp.Quizapp.model.Question;
import com.Springapp.Quizapp.service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @GetMapping("/allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Question>> getQuestionsBycategory(@PathVariable String category) {
        return questionService.getQuestionsBycategory(category);
    }


    @PostMapping("/add")
    public ResponseEntity<String> addQuestions(@RequestBody Question question) {
        return (questionService.addQuestions(question));
    }


    @DeleteMapping("/remove/{id}")
    public String removeQuestions(@PathVariable("id") int id) {
        return questionService.removeQuestion(id);
    }
}
