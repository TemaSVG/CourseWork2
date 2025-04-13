package org.skypro.Exam.examinerService.controller;

import org.skypro.Exam.examinerService.domain.Question;
import org.skypro.Exam.examinerService.mathservice.MathQuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam/math")
public class MathQuestionController {

    private final MathQuestionService mathQuestionService;

    public MathQuestionController(MathQuestionService mathQuestionService) {
        this.mathQuestionService = mathQuestionService;
    }

    @GetMapping("/add")
    public Question addQuestion(@RequestParam String question, @RequestParam String answer) {
        mathQuestionService.addQuestion(question, answer);
        return new Question(question, answer);
    }

    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam String question, @RequestParam String answer) {
        mathQuestionService.removeQuestion(question);
        return new Question(question, answer);
    }

    @GetMapping
    public Collection<Question> getAllQuestions() {
        return mathQuestionService.getAllQuestions();
    }

    @GetMapping("/random")
    public Question getRandomQuestion() {
        return mathQuestionService.getRandomQuestion();
    }
}