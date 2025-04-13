package org.skypro.Exam.serviceTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.skypro.Exam.examinerService.domain.Question;
import org.skypro.Exam.examinerService.repository.QuestionRepositoryImpl;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class QuestionRepositoryImplTest {

    private QuestionRepositoryImpl questionRepository;

    @BeforeEach
    void setUp() {
        questionRepository = new QuestionRepositoryImpl();
    }

    @Test
    void add_ShouldAddQuestion() {
        Question question = new Question("Что такое Java?", "Язык программирования");
        questionRepository.add(question);

        Collection<Question> questions = questionRepository.getAll();
        assertTrue(questions.contains(question));
    }

    @Test
    void remove_ShouldRemoveQuestion() {
        Question question = new Question("Что такое Java?", "Язык программирования");
        questionRepository.add(question);
        questionRepository.remove(question);

        Collection<Question> questions = questionRepository.getAll();
        assertFalse(questions.contains(question));
    }

    @Test
    void getAll_ShouldReturnAllQuestions() {
        Question question1 = new Question("Что такое Java?", "Язык программирования");
        Question question2 = new Question("Что такое Spring?", "Фреймворк");
        questionRepository.add(question1);
        questionRepository.add(question2);

        Collection<Question> questions = questionRepository.getAll();
        assertEquals(2, questions.size());
    }
}