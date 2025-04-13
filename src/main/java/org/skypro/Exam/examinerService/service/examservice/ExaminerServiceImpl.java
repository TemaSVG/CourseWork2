package org.skypro.Exam.examinerService.service.examservice;

import org.skypro.Exam.examinerService.domain.Question;
import org.skypro.Exam.examinerService.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService javaQuestionService;
    private final QuestionService mathQuestionService;
    private final Random random = new Random();

    public ExaminerServiceImpl(QuestionService javaQuestionService, QuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        List<Question> allQuestions = new ArrayList<>();
        allQuestions.addAll(javaQuestionService.getAllQuestions());
        allQuestions.addAll(mathQuestionService.getAllQuestions());

        if (amount > allQuestions.size()) {
            throw new IllegalArgumentException("Запрошенное количество вопросов превышает доступное.");
        }

        List<Question> selectedQuestions = new ArrayList<>();
        while (selectedQuestions.size() < amount) {
            Question randomQuestion = allQuestions.get(random.nextInt(allQuestions.size()));
            if (!selectedQuestions.contains(randomQuestion)) {
                selectedQuestions.add(randomQuestion);
            }
        }

        return selectedQuestions;
    }

}