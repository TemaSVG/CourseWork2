package org.skypro.Exam.examinerService.javaservice;

        import org.skypro.Exam.examinerService.domain.Question;
        import org.skypro.Exam.examinerService.repository.QuestionRepository;
        import org.skypro.Exam.examinerService.service.QuestionService;
        import org.springframework.stereotype.Service;

        import java.util.Collection;
        import java.util.Random;

        @Service
        public class JavaQuestionService implements QuestionService {

            private final QuestionRepository questionRepository;
            private final Random random = new Random();

            public JavaQuestionService(QuestionRepository questionRepository) {
                this.questionRepository = questionRepository;
            }

            @Override
            public void addQuestion(String question, String answer) {
                questionRepository.add(new Question(question, answer));
            }

            @Override
            public void removeQuestion(String question) {
                questionRepository.remove(new Question(question, null));
            }

            @Override
            public Collection<Question> getAllQuestions() {
                return questionRepository.getAll();
            }

            @Override
            public Question getRandomQuestion() {
                Collection<Question> questions = questionRepository.getAll();
                if (questions.isEmpty()) {
                    throw new IllegalStateException("Нет доступных вопросов");
                }
                return questions.stream().skip(random.nextInt(questions.size())).findFirst().orElseThrow();
            }
        }