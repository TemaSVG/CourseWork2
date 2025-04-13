package org.skypro.Exam.serviceTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.skypro.Exam.examinerService.domain.Question;
import org.skypro.Exam.examinerService.mathservice.MathQuestionService;
import org.skypro.Exam.examinerService.repository.QuestionRepositoryImpl;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class MathQuestionServiceTest {

    private MathQuestionService mathQuestionService;

    @BeforeEach
    void setUp() {
        mathQuestionService = new MathQuestionService(new QuestionRepositoryImpl());
    }

    @Test
    void addQuestion_ShouldAddQuestion() {
        Question question = new Question("2 + 2 = ?", "4");
        mathQuestionService.addQuestion(question.getQuestion(), question.getAnswer());

        Collection<Question> questions = mathQuestionService.getAllQuestions();
        assertTrue(questions.contains(question));
    }

    @Test
    void removeQuestion_ShouldRemoveQuestion() {
        Question question = new Question("2 + 2 = ?", "4");
        mathQuestionService.addQuestion(question.getQuestion(), question.getAnswer());
        mathQuestionService.removeQuestion(question.getQuestion());

        Collection<Question> questions = mathQuestionService.getAllQuestions();
        assertFalse(questions.equals(question));
    }

    @Test
    void getAllQuestions_ShouldReturnAllQuestions() {
        Question question1 = new Question("1 + 1 = ?", "2");
        Question question2 = new Question("3 + 3 = ?", "6");
        mathQuestionService.addQuestion(question1.getQuestion(), question1.getAnswer());
        mathQuestionService.addQuestion(question2.getQuestion(), question2.getAnswer());

        Collection<Question> questions = mathQuestionService.getAllQuestions();
        assertEquals(2, questions.size());
    }

    @Test
    void getRandomQuestion_ShouldReturnRandomQuestion() {
        Question question1 = new Question("1 + 1 = ?", "2");
        Question question2 = new Question("3 + 3 = ?", "6");
        mathQuestionService.addQuestion(question1.getQuestion(), question1.getAnswer());
        mathQuestionService.addQuestion(question2.getQuestion(), question2.getAnswer());

        Question randomQuestion = mathQuestionService.getRandomQuestion();
        assertNotNull(randomQuestion);
        assertTrue(mathQuestionService.getAllQuestions().contains(randomQuestion));
    }
}