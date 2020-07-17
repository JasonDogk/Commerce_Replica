package com.product.service.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.product.service.product.service.model.Product;
import com.product.service.product.service.repository.ProductRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private ProductRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@EnableWebSecurity
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable()
					.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
					.authorizeRequests().antMatchers(HttpMethod.POST, "/user").permitAll().anyRequest().authenticated();
		}
	}

	@Override
	public void run(String... args) throws Exception {

		Product product = new Product("product name", "product model", 13, "product description");

		userRepository.saveAndFlush(product);

		System.out.println(" ---------------@Query ---------------------");
		System.out.println("--------------findByEmailAddress -----------------");

		// Product user2 = userRepository.findByFirstName("onoma");
		// System.out.println(user2.toString());

		System.out.println(" ---------------@Query ---------------------");
		System.out.println("--------------findByLastname -----------------");

		// List<Product> user3 = userRepository.findAll();
		// System.out.println(user3.get(0).toString());
	}
}