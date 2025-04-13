package org.skypro.Exam.examinerService.repository;

import org.skypro.Exam.examinerService.domain.Question;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
public class QuestionRepositoryImpl implements QuestionRepository {

    private final List<Question> questions = new ArrayList<>();

    @Override
    public void add(Question question) {
        questions.add(question);
    }

    @Override
    public void remove(Question question) {
        questions.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return new ArrayList<>(questions);
    }
}