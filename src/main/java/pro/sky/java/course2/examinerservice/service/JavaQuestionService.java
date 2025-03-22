package pro.sky.java.course2.examinerservice.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.examinerservice.domain.Question;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService{

    private Set<Question> questions;
    private Random random = new Random();

    @Override              // Возвращает случайный вопрос
    public Question getRandomQuestion() {
        return new ArrayList<>(questions).get(random.nextInt( questions.size() ));
    }

}















