package com.msoft.security.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@GetMapping("/home")
	public String getHome() {
		return "This is a home page.";
	}
	
	@GetMapping("/user/home")
	public String getUserHome() {
		return "This is a user home page.";
	}
	
	@GetMapping("/admin/home")
	public String getAdminHome() {
		return "This is a admin home page.";
	}

}
