package org.skypro.Exam.examinerService.repository;

import org.skypro.Exam.examinerService.domain.Question;

import java.util.Collection;

public interface QuestionRepository {
    void add(Question question);
    void remove(Question question);
    Collection<Question> getAll();
}