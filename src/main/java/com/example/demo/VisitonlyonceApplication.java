package com.example.demo;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.hibernate.autoconfigure.HibernateJpaAutoConfiguration;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

import com.example.demo.util.TriviaLoader;
import com.example.demo.entity.TriviaQuestion;

// @SpringBootApplication
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class })
public class VisitonlyonceApplication {

	public static void main(String[] args) {
		SpringApplication.run(VisitonlyonceApplication.class, args);
		System.out.println("\n\n Visit Only Once Application Started");

		// List<TriviaQuestion> questions = TriviaLoader.load();
		// String allQuestions = questions.stream()
		// .map(TriviaQuestion::getQuestion)
		// .collect(Collectors.joining(", "));
		// System.out.println(allQuestions);

	}

}
