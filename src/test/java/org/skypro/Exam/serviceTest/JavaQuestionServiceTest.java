package org.skypro.Exam.serviceTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.skypro.Exam.examinerService.domain.Question;
import org.skypro.Exam.examinerService.javaservice.JavaQuestionService;
import org.skypro.Exam.examinerService.repository.QuestionRepository;
import org.skypro.Exam.examinerService.repository.QuestionRepositoryImpl;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {

    private JavaQuestionService javaQuestionService;

    @BeforeEach
    void setUp() {
        QuestionRepository QuestionRepository  = new QuestionRepositoryImpl();
        javaQuestionService = new JavaQuestionService(QuestionRepository);
    }

    @Test
    void addQuestion_ShouldAddQuestion() {
        Question question = new Question("What is Java?", "A programming language");
        javaQuestionService.addQuestion(question.getQuestion(), question.getAnswer());

        Collection<Question> questions = javaQuestionService.getAllQuestions();
        assertTrue(questions.contains(question));
    }

    @Test
    void removeQuestion_ShouldRemoveQuestion() {
        Question question = new Question("What is Java?", "A programming language");
        javaQuestionService.addQuestion(question.getQuestion(), question.getAnswer());
        javaQuestionService.removeQuestion(question.getQuestion());

        Collection<Question> questions = javaQuestionService.getAllQuestions();
        assertFalse(questions.equals(question));
    }

    @Test
    void getAllQuestions_ShouldReturnAllQuestions() {
        Question question1 = new Question("What is Java?", "A programming language");
        Question question2 = new Question("What is Spring?", "A framework");
        javaQuestionService.addQuestion(question1.getQuestion(), question1.getAnswer());
        javaQuestionService.addQuestion(question2.getQuestion(), question2.getAnswer());

        Collection<Question> questions = javaQuestionService.getAllQuestions();
        assertEquals(2, questions.size());
    }

    @Test
    void getRandomQuestion_ShouldReturnRandomQuestion() {
        Question question = new Question("What is Java?", "A programming language");
        javaQuestionService.addQuestion(question.getQuestion(), question.getAnswer());

        Question randomQuestion = javaQuestionService.getRandomQuestion();
        assertNotNull(randomQuestion);
        assertEquals(question, randomQuestion);
    }
}