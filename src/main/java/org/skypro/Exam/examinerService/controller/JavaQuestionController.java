package org.skypro.Exam.examinerService.controller;

            import org.skypro.Exam.examinerService.domain.Question;
            import org.skypro.Exam.examinerService.service.QuestionService;
            import org.springframework.http.ResponseEntity;
            import org.springframework.web.bind.annotation.*;

            import java.util.Collection;

            @RestController
            @RequestMapping("/exam/java")
            public class JavaQuestionController {

                private final QuestionService questionService;

                public JavaQuestionController(QuestionService questionService) {
                    this.questionService = questionService;
                }

                @PostMapping("/add")
                public ResponseEntity<Question> addQuestion(@RequestParam String question, @RequestParam String answer) {
                    questionService.addQuestion(question, answer);
                    return ResponseEntity.ok(new Question(question, answer));
                }

                @DeleteMapping("/remove")
                public ResponseEntity<Question> removeQuestion(@RequestParam String question) {
                    questionService.removeQuestion(question);
                    return ResponseEntity.ok(new Question(question, null));
                }

                @GetMapping
                public ResponseEntity<Collection<Question>> getAllQuestions() {
                    return ResponseEntity.ok(questionService.getAllQuestions());
                }

                @GetMapping("/random")
                public ResponseEntity<Question> getRandomQuestion() {
                    return ResponseEntity.ok(questionService.getRandomQuestion());
                }
            }