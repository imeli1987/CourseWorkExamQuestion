package pro.sky.java.course2.examinerservice.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.repository.JavaQuestionRepository;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {

    @Mock
    private JavaQuestionService testJavaQuestionService;

    @Mock
    private JavaQuestionRepository testJavaQuestionRepository;

    @BeforeEach
    void setUp() {
        testJavaQuestionService = new JavaQuestionService();
        testJavaQuestionRepository = new JavaQuestionRepository();
    }

    @Test
    void testGetAll() {
        Question testQuestion = new Question("Question", "Answer");
        testJavaQuestionRepository.add(testQuestion);

        assertEquals(1, testJavaQuestionRepository.getAll().size());
    }

    @Test
    void testGetRandomQuestion() {

        Question testQuestion1 = new Question("Question 1", "Answer 1");
        Question testQuestion2 = new Question("Question 2", "Answer 2");
        testJavaQuestionRepository.add(testQuestion1);
        testJavaQuestionRepository.add(testQuestion2);

        Question randomQuestion = testJavaQuestionService.getRandomQuestion();

        assertTrue(randomQuestion.equals(testQuestion1) || randomQuestion.equals( testQuestion2));
        assertNotNull(randomQuestion);
    }

    @Test
    void testAddQuestion() {
        Question question = new Question("Test question", "Test answer");

        testJavaQuestionRepository.add(question);

        assertTrue(testJavaQuestionRepository.getAll().contains(question));
    }

    @Test
    void testRemoveQuestion() {
        Question question = new Question("Test", "Test");

        testJavaQuestionRepository.add(question);

        testJavaQuestionRepository.remove(question);

        assertFalse(testJavaQuestionRepository.getAll().contains(question));
        assertEquals(0, testJavaQuestionRepository.getAll().size());
    }

    @Test
    void testRemoveNonExistentQuestion() {
        Question question = new Question("Test question", "Test answer");

        testJavaQuestionRepository.remove(question);

        assertFalse(testJavaQuestionRepository.getAll().contains(question));
    }
}

