package pro.sky.java.course2.examinerservice.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.repository.QuestionRepository;

import java.util.*;

@Service
public class MathQuestionService implements QuestionService, QuestionRepository{

    private Set<Question> mathQuestions;
    private Random random = new Random();

    public MathQuestionService( ){
        mathQuestions = new HashSet<>();
    }

    @Override              // Добавляет вопрос в коллекцию
    public void add( String q, String a ) {
        mathQuestions.add( new Question(q, a) );
    }

    @Override
    public void add( Question question ) {
            mathQuestions.add( question );
    }

    @Override                 // Удаляет вопрос из коллекции
    public void remove( String q) {
            mathQuestions.removeIf( question -> question.equals( q ));
        }

    @Override
    public void remove( Question question ) {
            mathQuestions.remove(question);
        }

    @Override                     // Возвращает коллекцию всех вопросов
    public Collection<Question> getAll() {
            return Collections.unmodifiableSet( mathQuestions );
        }

    @Override              // Возвращает случайный вопрос
    public Question getRandomQuestion() {
        return new ArrayList<>( mathQuestions ).get(random.nextInt( mathQuestions.size() ));
    }
}
