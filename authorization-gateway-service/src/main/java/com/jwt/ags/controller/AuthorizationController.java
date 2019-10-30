package com.jwt.ags.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.ags.impl.AuthorizationImpl;
import com.jwt.ags.model.Credential;

@RestController
@RequestMapping("/authorization")
public class AuthorizationController {

	@Autowired
	private AuthorizationImpl authorizationImpl;
	
	private Credential globalCredential = null;

	@PostMapping(value = "/authenticate")
	public ResponseEntity<Credential> authenticate(@RequestBody String jwtBase64) {
		Credential credential = new Credential();
		try {
			globalCredential = authorizationImpl.authenticate(jwtBase64);
		} catch (Exception e) {
			return new ResponseEntity<>(credential, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<>(globalCredential,
				credential.getStatusCode() == 200 ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping(value = "/credential")
	public Credential getCredential() {
		return globalCredential;
	}
}
