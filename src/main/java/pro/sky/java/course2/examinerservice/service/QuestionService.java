package pro.sky.java.course2.examinerservice.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.examinerservice.domain.Question;

import java.util.Collection;

@Service
public interface QuestionService{
//    void add( String question, String answer );
//    void add( Question question );
//
//    void remove( String question );
//    void remove( Question question );
//
//    Collection<Question> getAll();
    Question getRandomQuestion();

}
