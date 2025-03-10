package pro.sky.java.course2.examinerservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.service.JavaQuestionService;
import pro.sky.java.course2.examinerservice.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("exam/java")
public class JavaQuestionController{

    private QuestionService service;
    private final JavaQuestionService javaQuestionService = new JavaQuestionService();

    @GetMapping()
    public Collection<Question> getQuestions(){
        return javaQuestionService.getAll();
    }

    @GetMapping("/add")
    public void addQuestion( @RequestParam String question, @RequestParam String answer ){
        javaQuestionService.add( question, answer );
    }

    @GetMapping("/remove")
    public void removeQuestion( @RequestParam String q ){
        javaQuestionService.remove( q );
    }

}
