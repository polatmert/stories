package com.stories.ws.auth;

import com.stories.ws.shared.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonView;
import com.stories.ws.shared.Views;
import com.stories.ws.user.User;
import com.stories.ws.user.UserRepository;

@RestController
public class AuthController {

	@Autowired
	UserRepository userRepository;

	@PostMapping("/api/1.0/auth")
	@JsonView(Views.Base.class)
	ResponseEntity<?> handleAuthentication(@CurrentUser  User user) {
		return ResponseEntity.ok(user);
	}
}