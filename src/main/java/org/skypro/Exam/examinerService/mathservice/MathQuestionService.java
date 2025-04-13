package org.skypro.Exam.examinerService.mathservice;

        import org.skypro.Exam.examinerService.domain.Question;
        import org.skypro.Exam.examinerService.repository.QuestionRepository;
        import org.skypro.Exam.examinerService.service.QuestionService;
        import org.springframework.stereotype.Service;

        import java.util.Collection;
        import java.util.Random;

        @Service
        public class MathQuestionService implements QuestionService {

            private final QuestionRepository questionRepository;
            private final Random random = new Random();

            public MathQuestionService(QuestionRepository questionRepository) {
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

            private void generateMathQuestions(int count) {
                for (int i = 0; i < count; i++) {
                    int a = random.nextInt(100);
                    int b = random.nextInt(100);
                    String question = a + " + " + b + " = ?";
                    String answer = String.valueOf(a + b);
                    questionRepository.add(new Question(question, answer));
                }
            }
        }