package com.stories.ws.auth;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonView;
import com.stories.ws.error.ApiError;
import com.stories.ws.shared.GenericResponse;
import com.stories.ws.shared.Views;
import com.stories.ws.user.User;
import com.stories.ws.user.UserRepository;

@RestController
public class AuthController {

	@Autowired
	UserRepository userRepository;

	@PostMapping("/api/1.0/auth")
	@JsonView(Views.Base.class)
	ResponseEntity<?> handleAuthentication(@RequestHeader(name = "Authorization") String authorization) {
		String baseEncoded = authorization.split("Basic ")[1];
		String decoded = new String(Base64.getDecoder().decode(baseEncoded));
		String[] parts = decoded.split(":");
		String username = parts[0];
		User inDB = userRepository.findByUsername(username);

		return ResponseEntity.ok(inDB);
	}
}
