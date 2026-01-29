package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.TriviaQuestion;
import com.example.demo.util.TriviaLoader;

@Service
public class TriviaService {

    public List<TriviaQuestion> shuffleAndLimit(List<TriviaQuestion> questions, int limit) {
        List<TriviaQuestion> shuffled = TriviaLoader.shuffle(questions);
        if (limit > shuffled.size()) {
            limit = shuffled.size();
        }
        return shuffled.subList(0, limit);
    }
}
