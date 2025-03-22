package pro.sky.java.course2.examinerservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.repository.QuestionRepository;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class ExaminerServiceImpl implements ExaminerService{

    @Autowired
    private final QuestionService questionService;
    private final QuestionRepository questionRepository;

    @Autowired
    public ExaminerServiceImpl( QuestionService questionService,
                                QuestionRepository questionRepository ){

        this.questionService = questionService;
        this.questionRepository = questionRepository;
    }

    @Override
    public Collection<Question> getQuestions( int amount ){
        if (amount <= 0 || amount > questionRepository.getAll().size()){
            throw new ResponseStatusException( HttpStatus.BAD_REQUEST, "Ввели неверное количество вопросов" );
        }
        ArrayList<Question> questions = new ArrayList<>();
        while (questions.size() < amount){
            Question question = questionService.getRandomQuestion();
            if (!questions.contains(question) && question != null){
                questions.add(question);
            }
        }
        return questions;
    }

}
