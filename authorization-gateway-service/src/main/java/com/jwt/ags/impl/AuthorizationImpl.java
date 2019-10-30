package com.jwt.ags.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.jwt.ags.model.Credential;
import com.jwt.ags.util.ConfigProperties;
import com.jwt.ags.util.JwtUtil;

@Component
public class AuthorizationImpl {
	
	@Autowired
	private JwtUtil jwtUtil;
 
	@Autowired
	private ConfigProperties config;
	
	public Credential authenticate(String jwt) throws Exception{
		Credential credential = jwtUtil.decodeBase64InCredencial(jwt);

		if(!credential.getSignatureKey().equals(config.getConfigValue("jwt.user.key"))){
			credential.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			credential.setReturnMessage("INVALID KEY");
		}else{
			credential.setStatusCode(HttpStatus.OK.value());
			credential.setReturnMessage("SUCCESS");
		}
		
		return credential;
	}
}
