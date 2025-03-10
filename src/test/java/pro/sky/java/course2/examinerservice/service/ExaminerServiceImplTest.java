package pro.sky.java.course2.examinerservice.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.examinerservice.domain.Question;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    private ExaminerServiceImpl examinerServiceImpl;
    private JavaQuestionService javaQuestionService;

    @BeforeEach
    void setUp() {
        javaQuestionService = new JavaQuestionService();
        examinerServiceImpl = new ExaminerServiceImpl(javaQuestionService);
    }

    @Test
    public void getQuestionsTest() {
        Question question1 = new Question("Question1", "Answer1");
        Question question2 = new Question("Question2", "Answer2");
        Question question3 = new Question("Question3", "Answer3");

        javaQuestionService.add(question1);
        javaQuestionService.add(question2);
        javaQuestionService.add(question3);

        Collection<Question> questions = examinerServiceImpl.getQuestions(3);

        assertEquals(3, questions.size());
    }



}