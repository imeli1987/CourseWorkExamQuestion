package pro.sky.java.course2.examinerservice.repository;

import pro.sky.java.course2.examinerservice.domain.Question;

import java.util.Collection;

public interface QuestionRepository {

    void add( String question, String answer );
    void add( Question question );

    void remove( String question );
    void remove( Question question );

    Collection<Question> getAll();
}
