package com.gaf.integration;

import com.gaf.integration.model.Contact;
import com.gaf.integration.repository.ContactRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.LongStream;

@SpringBootApplication
public class SpringApplication {

	public static void main(String[] args) {
		org.springframework.boot.SpringApplication.run(SpringApplication.class, args);
	}

	@Bean
	CommandLineRunner init(ContactRepository repository) {
		return args -> {
			repository.deleteAll();
			LongStream.range(1, 11)
					.mapToObj(i -> new Contact(i, "Contact " + i, "contact" + i + "@email.com", "(111) 111-1111"))
					.map(v -> repository.save(v))
					.forEach(System.out::println);
		};

	}
}
