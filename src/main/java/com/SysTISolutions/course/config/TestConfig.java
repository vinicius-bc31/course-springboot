package com.SysTISolutions.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.SysTISolutions.course.entities.Category;
import com.SysTISolutions.course.entities.Order;
import com.SysTISolutions.course.entities.Product;
import com.SysTISolutions.course.entities.User;
import com.SysTISolutions.course.entities.enums.OrderStatus;
import com.SysTISolutions.course.repositories.CategoryRepository;
import com.SysTISolutions.course.repositories.OrderRepository;
import com.SysTISolutions.course.repositories.ProductRepository;
import com.SysTISolutions.course.repositories.UserRepository;

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
		
		
		Category cat1 = new Category(null, "Processor");
		Category cat2 = new Category(null, "Video_cards");
		Category cat3 = new Category(null, "Peripherals");
		Category cat4 = new Category(null, "Gamer");
		
		Product p1 = new Product(null, "AMD RX 5700 XT", "Sapphire Pulse - 8GB - GDDR6", 2799.9, "");
		Product p2 = new Product(null, "AMD Ryzen 9 3900XT", "cache 70MB - 12c/24t - 3.8/4.7GHz - AM4", 3599.90, "");
		Product p3 = new Product(null, "Intel core i9 10900K", "cache 20MB - 10c/20t - 3.7/5.2GHz - LGA1200", 4089.9, "");
		Product p4 = new Product(null, "AMD Ryzen 3 3300X", "cache 18MB - 4c/8t - 3.8/4.3GHz", 969.9, "");
		Product p5 = new Product(null, "Headset Gamer Corsair HS60 PRO", "USB/P2, Surround 7.1, Drivers 50mm", 531.9, "");
		
		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3,cat4));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		
		p1.getCategories().add(cat2);
		p1.getCategories().add(cat4);
		p2.getCategories().add(cat1);
		p3.getCategories().add(cat1);
		p4.getCategories().add(cat1);
		p5.getCategories().add(cat3);
		p5.getCategories().add(cat4);
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
	}
	
	
}
