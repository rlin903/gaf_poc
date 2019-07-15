package com.gaf.integration;

import com.gaf.integration.model.Contact;
import com.gaf.integration.repository.ContactRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.LongStream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringApplicationTests {

	@Test
	public void contextLoads() {
	}

//	@Bean
//	CommandLineRunner init(ContactRepository repository) {
//		return args -> {
//			repository.deleteAll();
//			LongStream.range(1, 11)
//					.mapToObj(i -> new Contact(i, "Contact " + i, "contact" + i + "@email.com", "(111) 111-1111"))
//					.map(v -> repository.save(v))
//					.forEach(System.out::println);
//		};
//
//	}

}
