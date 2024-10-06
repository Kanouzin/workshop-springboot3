package com.projeto.curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projeto.curso.entities.Category;
import com.projeto.curso.entities.Order;
import com.projeto.curso.entities.Product;
import com.projeto.curso.entities.User;
import com.projeto.curso.entities.enums.OrderStatus;
import com.projeto.curso.repositories.CategoryRepository;
import com.projeto.curso.repositories.OrderRepository;
import com.projeto.curso.repositories.ProductRepository;
import com.projeto.curso.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {

		Category cat1 = new Category(null, "Eletronicos");
		Category cat2 = new Category(null, "Livros");
		Category cat3 = new Category(null, "Computadores");
		
		Product p1 = new Product(null, "Harry Potter", "Um bruxo muito louco.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Tv inteligente.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Macbook Apple.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Pc roda tudo.", 1200.0, "");
		Product p5 = new Product(null, "God of War", "Um deus muito louco no egito.", 100.99, ""); 

		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		User u1 = new User(null, "Maria Beta", "maria@gmail.com", "940028921", "123456");
		User u2 = new User(null, "Alex Sigma", "alex@gmail.com", "940028923", "123456");

		Order o1 = new Order(null, Instant.parse("2024-10-05T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2024-10-04T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2024-10-03T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);

		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}

}