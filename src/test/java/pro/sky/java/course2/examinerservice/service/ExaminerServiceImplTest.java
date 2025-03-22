package pro.sky.java.course2.examinerservice.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.repository.JavaQuestionRepository;
import pro.sky.java.course2.examinerservice.repository.MathQuestionRepository;
import pro.sky.java.course2.examinerservice.repository.QuestionRepository;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    private ExaminerServiceImpl examinerServiceImpl;
    private JavaQuestionService javaQuestionService;
    private MathQuestionService mathQuestionService;
    private QuestionRepository questionRepository;
    private MathQuestionRepository mathQuestionRepository;
    private JavaQuestionRepository javaQuestionRepository;

    @BeforeEach
    void setUp() {
        mathQuestionRepository = new MathQuestionRepository();
        javaQuestionRepository = new JavaQuestionRepository();
        examinerServiceImpl = new ExaminerServiceImpl( javaQuestionService, mathQuestionService );
    }

    @Test
    public void getQuestionsTest() {
        Question question1 = new Question("Question1", "Answer1");
        Question question2 = new Question("Question2", "Answer2");
        Question question3 = new Question("Question3", "Answer3");

        Question mathQuestion1 = new Question("MathQuestion1", "MathAnswer1");
        Question mathQuestion2 = new Question("MathQuestion2", "MathAnswer2");

        javaQuestionRepository.add(question1);
        javaQuestionRepository.add(question2);
        javaQuestionRepository.add(question3);

        mathQuestionRepository.add(mathQuestion1);
        mathQuestionRepository.add(mathQuestion2);

        Collection<Question> questions = examinerServiceImpl.getQuestions(3);

        assertEquals(3, questions.size());
    }
}