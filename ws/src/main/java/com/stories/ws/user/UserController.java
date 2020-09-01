package com.stories.ws.user;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stories.ws.error.ApiError;
import com.stories.ws.shared.GenericResponse;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	// Post requestlerde çalışması için @PostMapping kullandım.
	// CrossOrigin ui ile backend arasındaki port problemi için kullanılır.
	@PostMapping("/api/1.0/users")
	public ResponseEntity<?> createUser(@RequestBody User user) {
		ApiError errorApi = new ApiError(400, "validation Error", "/api/1.0/users");
		Map<String, String> validationErrors = new HashMap<>();
		String username = user.getUsername();
		String displayName = user.getDisplayname();
		
		if (username == null || username.isEmpty()) {
			validationErrors.put("username", "Username cannot be null");
		}

		if (displayName == null || displayName.isEmpty()) {
			validationErrors.put("displayName", "Cannot be null");
		}

		if (validationErrors.size() > 0) {
			errorApi.setValidationErrors(validationErrors);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorApi);
		}
		
		userService.save(user);
		return ResponseEntity.ok("user created");
	}

}