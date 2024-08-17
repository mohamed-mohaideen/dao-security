package com.msoft.security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.msoft.security.demo.dto.UserInfo;
import com.msoft.security.demo.model.User;
import com.msoft.security.demo.repo.UserRepository;

@RestController
public class RegisterController {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PasswordEncoder encoder;

	@PostMapping("/sign-up")
	public ResponseEntity<String> createUser(@RequestBody UserInfo userInfo) {
		User user = User.builder().username(userInfo.username())
		.password(encoder.encode(userInfo.password()))
		.roles(String.join(",", userInfo.roles()))
		.build();
		
		user = userRepo.save(user);
		return new ResponseEntity<String>(
				"Created Successfully with id %s".formatted(user.getId()), HttpStatus.CREATED);
	}
}
