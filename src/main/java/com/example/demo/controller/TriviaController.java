package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.TriviaQuestion;
import com.example.demo.service.TriviaService;
import com.example.demo.util.TriviaLoader;

import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "http://localhost:3000")
public class TriviaController {

    @Autowired
    private TriviaService triviaService;

    @GetMapping("/check")
    public String getTrivia() {
        return "Welcome to the Trivia API!";
    }

    @GetMapping("/trivia")
    public List<TriviaQuestion> getTriviaQuestions(@RequestParam(defaultValue = "3") int limit) {
        List<TriviaQuestion> allQuestions = TriviaLoader.load();
        allQuestions = triviaService.shuffleAndLimit(allQuestions, limit);

        if (limit > allQuestions.size()) {
            limit = allQuestions.size();
        }

        return allQuestions.subList(0, limit);
    }

}
