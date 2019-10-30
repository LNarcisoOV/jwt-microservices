package com.jwt.ags.util;

import java.security.Key;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpStatus;

import com.google.gson.Gson;
import com.jwt.ags.model.Credential;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;

public class JwtUtil {

	// eyJhbGciOiJIUzI1NiJ9.CXsgCgkJImxvZ2luIjoic3lzdGVtIiwKCQkicGFzc3dvcmQiOiIxMjM0NTYiICAgIAoJfQ.V13npBxBJDJ8YzNXicSt_nr7fgQtNfCcJQ2YdGMBxIU

	public static String encode(String json) {
		Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
		return Jwts.builder().setPayload(json).signWith(key).compact();
	}

	public static Credential decode(String jwt) throws SignatureException, ExpiredJwtException,
			UnsupportedJwtException, MalformedJwtException, IllegalArgumentException {
		Credential credential = new Credential();
		try {
			Base64 base64 = new Base64(true);

			String[] splitedToken = jwt.split("\\.");
			String header = new String(base64.decode(splitedToken[0]));
			String body = new String(base64.decode(splitedToken[1]));
			String signature = new String(base64.decode(splitedToken[2]));

			credential = new Gson().fromJson(body, Credential.class);
			credential.setStatusCode(HttpStatus.OK.value());
			credential.setReturnMessage("SUCCESS");
			
			return credential;
		} catch (Exception e) {
			e.printStackTrace();
			return new Credential(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
	}
}
