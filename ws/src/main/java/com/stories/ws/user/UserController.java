package com.stories.ws.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stories.ws.shared.GenericResponse;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	// Post requestlerde çalışması için @PostMapping kullandım.
	// CrossOrigin ui ile backend arasındaki port problemi için kullanılır.
	@PostMapping("/api/1.0/users")
	public GenericResponse createUser(@RequestBody User user) {
		userService.save(user);
		return new GenericResponse("user created");
	}

}