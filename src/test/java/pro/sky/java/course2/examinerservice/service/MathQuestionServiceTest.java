package pro.sky.java.course2.examinerservice.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.java.course2.examinerservice.domain.Question;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MathQuestionServiceTest{

    private MathQuestionService testMathQuestionService;

    @BeforeEach
    void setUp() {
        testMathQuestionService = new MathQuestionService();
    }

    @Test
    void testAdd(){
        Set<Question> questions = new HashSet<>();

        assertTrue( questions.isEmpty() );

        Question question = new Question("Question", "Answer");
        questions.add( question );

        assertEquals( 1, questions.size() );

        String q = "Question";
        String a = "Answer";

        Question question2 = new Question(q, a);
        questions.add( question2 );

        assertEquals( 2, questions.size() );
    }

    @Test
    void testRemove(){
    }

    @Test
    void getAll(){
    }

    @Test
    void getRandomQuestion(){
    }
}