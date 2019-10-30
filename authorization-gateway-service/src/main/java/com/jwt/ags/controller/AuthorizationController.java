package com.jwt.ags.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.ags.model.Credential;
import com.jwt.ags.util.JwtUtil;

@RestController
@RequestMapping("/authorization")
public class AuthorizationController {

	@PostMapping(value = "/authenticate")
	public ResponseEntity<Credential> authenticate(@RequestBody String jwt) {
		Credential credential = JwtUtil.decode(jwt);
		return new ResponseEntity<>(credential,
				credential.getStatusCode() == 200 ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
