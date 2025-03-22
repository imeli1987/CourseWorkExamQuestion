package pro.sky.java.course2.examinerservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.repository.JavaQuestionRepository;

import java.util.Collection;

@RestController
@RequestMapping ("exam/java")
public class JavaQuestionController{

    private JavaQuestionRepository repository = new JavaQuestionRepository();

    @GetMapping()
    public Collection<Question> getQuestions(){
        return repository.getAll();
    }

    @GetMapping("/add")
    public void addQuestion( @RequestParam String question, @RequestParam String answer ){
        repository.add( question, answer );
    }

    @GetMapping("/remove")
    public void removeQuestion( @RequestParam String q ){
        repository.remove( q );
    }
}
