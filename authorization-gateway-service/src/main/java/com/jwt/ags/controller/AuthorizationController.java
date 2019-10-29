package com.jwt.ags.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authorization")
public class AuthorizationController {
	
	@PostMapping(value = "/authenticate")
	public String authenticate(@RequestBody String jwt){
		return "";
	}
}
