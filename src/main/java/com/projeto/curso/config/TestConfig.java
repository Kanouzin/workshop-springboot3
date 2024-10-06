package com.projeto.curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projeto.curso.entities.Order;
import com.projeto.curso.entities.User;
import com.projeto.curso.repositories.OrderRepository;
import com.projeto.curso.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Maria Beta", "maria@gmail.com", "940028921", "123456");
		User u2 = new User(null, "Alex Sigma", "alex@gmail.com", "940028923", "123456");
		
		Order o1 = new Order(null, Instant.parse("2024-10-05T19:53:07Z"), u1);
		Order o2 = new Order(null, Instant.parse("2024-10-04T03:42:10Z"), u2);
		Order o3 = new Order(null, Instant.parse("2024-10-03T15:21:22Z"), u1); 
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
	
	
}