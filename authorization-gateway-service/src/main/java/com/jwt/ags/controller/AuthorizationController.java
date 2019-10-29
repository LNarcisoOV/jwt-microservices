package com.jwt.ags.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonSyntaxException;
import com.jwt.ags.model.Credential;
import com.jwt.ags.util.JwtUtil;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.SignatureException;

@RestController
@RequestMapping("/authorization")
public class AuthorizationController {

	@PostMapping(value = "/authenticate")
	public ResponseEntity<Credential> authenticate(@RequestBody String jwt) {
		try {
			Credential credential = JwtUtil.decode(jwt);
			credential.setStatusCode(HttpStatus.OK.value());
			credential.setReturnMessage("SUCCESS");

			return new ResponseEntity<>(credential, HttpStatus.OK);
		} catch (SignatureException | ExpiredJwtException | UnsupportedJwtException | MalformedJwtException
				| IllegalArgumentException | JsonSyntaxException e) {
			return new ResponseEntity<>(
					new Credential(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
