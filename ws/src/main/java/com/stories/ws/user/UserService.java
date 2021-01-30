package com.stories.ws.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	UserRepository userRepository;
	
	PasswordEncoder passwordEncoder;
	
	public UserService(UserRepository userRepository , PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public void save(User user) {
		String encyptedPassword =  this.passwordEncoder.encode(user.getPassword());
		user.setPassword(encyptedPassword);
		userRepository.save(user);
	}

}