package com.example;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sebastian Börebäck on 2016-04-19.
 */
@RestController
public class HomeController {

	@RequestMapping("/user")
	public Principal user(Principal user) {
		return user;
	}

	@RequestMapping("/resource")
	public Map<String, Object> home() {
		Map<String, Object> model = new HashMap<String, Object>();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		model.put("id", auth.getName());
		model.put("content", "Hello World");
		return model;
	}
}
