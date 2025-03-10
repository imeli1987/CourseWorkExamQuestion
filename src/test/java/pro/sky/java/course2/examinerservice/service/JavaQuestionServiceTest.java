package pro.sky.java.course2.examinerservice.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import pro.sky.java.course2.examinerservice.domain.Question;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {

    @Mock
    private JavaQuestionService testJavaQuestionService;

    @BeforeEach
    void setUp() {
        testJavaQuestionService = new JavaQuestionService();
    }

    @Test
    void testGetAll() {
        Question testQuestion = new Question("Question", "Answer");
        testJavaQuestionService.add(testQuestion);

        assertEquals(1, testJavaQuestionService.getAll().size());
    }

    @Test
    void testGetRandomQuestion() {

        Question testQuestion1 = new Question("Question 1", "Answer 1");
        Question testQuestion2 = new Question("Question 2", "Answer 2");
        testJavaQuestionService.add(testQuestion1);
        testJavaQuestionService.add(testQuestion2);

        Question randomQuestion = testJavaQuestionService.getRandomQuestion();

        assertTrue(randomQuestion.equals(testQuestion1) || randomQuestion.equals( testQuestion2));
        assertNotNull(randomQuestion);
    }

    @Test
    void testAddQuestion() {
        Question question = new Question("Test question", "Test answer");

        testJavaQuestionService.add(question);

        assertTrue(testJavaQuestionService.getAll().contains(question));
    }

    @Test
    void testRemoveQuestion() {
        Question question = new Question("Test", "Test");

        testJavaQuestionService.add(question);

        testJavaQuestionService.remove(question);

        assertFalse(testJavaQuestionService.getAll().contains(question));
        assertEquals(0, testJavaQuestionService.getAll().size());
    }

    @Test
    void testRemoveNonExistentQuestion() {
        Question question = new Question("Test question", "Test answer");

        testJavaQuestionService.remove(question);

        assertFalse(testJavaQuestionService.getAll().contains(question));
    }

}