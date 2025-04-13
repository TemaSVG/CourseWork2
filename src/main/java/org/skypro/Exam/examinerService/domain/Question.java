package org.skypro.Exam.examinerService.domain;

import org.skypro.Exam.examinerService.service.QuestionService;

import java.util.Objects;

public class Question {
    private String question;
    private String answer;

    public Question(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return Objects.equals(this.question, question.question) &&
                Objects.equals(this.answer, question.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(question, answer);
    }
}
