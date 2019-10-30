package com.jwt.ags.util;

import java.security.Key;

import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.jwt.ags.model.Credential;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

	// eyJhbGciOiJIUzI1NiJ9.CXsgCgkJImxvZ2luIjoic3lzdGVtIiwKCQkicGFzc3dvcmQiOiIxMjM0NTYiICAgIAoJfQ.V13npBxBJDJ8YzNXicSt_nr7fgQtNfCcJQ2YdGMBxIU

	public String encodeJsonIntoBase64Jwt(String json) {
		Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
		return Jwts.builder().setPayload(json).signWith(key).compact();
	}

	public Credential decodeBase64InCredencial(String jwtBase64) throws Exception {

		Credential credential = new Credential();

		Base64 base64 = new Base64(true);

		String[] splitedToken = jwtBase64.split("\\.");
		String header = new String(base64.decode(splitedToken[0]));
		String body = new String(base64.decode(splitedToken[1]));
		String signature = splitedToken[2];

		credential = new Gson().fromJson(body, Credential.class);
		credential.setSignatureKey(signature);

		return credential;
	}
}
