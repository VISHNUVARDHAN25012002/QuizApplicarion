package com.Springapp.Quizapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Springapp.Quizapp.model.Quiz;

public interface QuizDao extends JpaRepository<Quiz, Integer>{

}
