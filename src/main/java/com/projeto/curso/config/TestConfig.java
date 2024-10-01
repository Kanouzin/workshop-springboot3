package com.projeto.curso.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projeto.curso.entities.User;
import com.projeto.curso.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Maria Beta", "maria@gmail.com", "940028921", "123456");
		User u2 = new User(null, "Alex Sigma", "alex@gmail.com", "940028923", "123456");
		
		userRepository.saveAll(Arrays.asList(u1, u2));
	}
	
	
}