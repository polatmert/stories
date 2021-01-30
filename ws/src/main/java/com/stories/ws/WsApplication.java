package com.stories.ws;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

import com.stories.ws.user.User;
import com.stories.ws.user.UserService;

@SpringBootApplication
public class WsApplication {

	public static void main(String[] args) {
		SpringApplication.run(WsApplication.class, args);
	}

	// Dummy Data
	@Bean
	CommandLineRunner createInitialUsers(UserService userservice) {
		return new CommandLineRunner() {

			@Override
			public void run(String... args) throws Exception {
				User user = new User();
				user.setUsername("user1");
				user.setPassword("Password1");
				user.setDisplayName("display1");
				userservice.save(user);
			}
		};
	}

}
