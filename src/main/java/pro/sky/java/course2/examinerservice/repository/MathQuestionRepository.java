package pro.sky.java.course2.examinerservice.repository;

import pro.sky.java.course2.examinerservice.domain.Question;

import java.util.*;

public class MathQuestionRepository implements QuestionRepository{

    private Question question;
    private Set<Question> questions;
    private Random random = new Random();

    public  void JavaQuestionService( ){
        questions = new HashSet<>();
    }

    @Override              // Добавляет вопрос в коллекцию
    public void add( String q, String a ) {
        questions.add( new Question(q, a) );
    }

    @Override
    public void add( Question question ) {
        questions.add( question );
    }

    @Override                 // Удаляет вопрос из коллекции
    public void remove( String q) {
        questions.removeIf( question -> question.equals( q ));
    }

    @Override
    public void remove( Question question ) {
        questions.remove(question);
    }

    @Override                     // Возвращает коллекцию всех вопросов
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(questions);
    }
}
