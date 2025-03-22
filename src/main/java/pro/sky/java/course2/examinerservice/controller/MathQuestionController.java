package pro.sky.java.course2.examinerservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.repository.MathQuestionRepository;

import java.util.Collection;

@RestController
@RequestMapping ("exam/math")
public class MathQuestionController{

    private MathQuestionRepository repo = new MathQuestionRepository();

    @GetMapping()
    public Collection<Question> getQuestions(){
            return repo.getAll();
        }

    @GetMapping("/add")
    public void addQuestion( @RequestParam String question, @RequestParam String answer ){
        repo.add( question, answer );
    }

    @GetMapping("/remove")
    public void removeQuestion( @RequestParam String q ){
            repo.remove( q );
        }
}