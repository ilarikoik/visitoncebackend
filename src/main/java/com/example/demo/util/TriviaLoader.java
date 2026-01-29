package com.example.demo.util;

import com.example.demo.entity.TriviaQuestion;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class TriviaLoader {

    public static List<TriviaQuestion> load() {
        try {

            ObjectMapper mapper = new ObjectMapper();

            InputStream is = TriviaLoader.class
                    .getClassLoader()
                    .getResourceAsStream("trivia/trivia.json");

            if (is == null) {
                throw new RuntimeException("Trivia file not found");
            }

            return mapper.readValue(is, new TypeReference<List<TriviaQuestion>>() {
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<TriviaQuestion> shuffle(List<TriviaQuestion> questions) {
        Collections.shuffle(questions);
        return questions;

    }
}
