package org.skypro.Exam.examinerService.service;

import org.skypro.Exam.examinerService.domain.Question;

import java.util.Collection;


public interface QuestionService {
    void addQuestion(String question, String answer);
    void removeQuestion(String question);
    Collection<Question> getAllQuestions();
    Question getRandomQuestion();
}