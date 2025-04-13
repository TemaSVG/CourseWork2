package org.skypro.Exam.examinerService.service.examservice;

import org.skypro.Exam.examinerService.domain.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}