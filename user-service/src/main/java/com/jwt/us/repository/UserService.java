package com.jwt.us.repository;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.jwt.us.model.Credential;

@FeignClient(name = "${authorization.gateway.service.host}")
@RibbonClient(name = "${authorization.gateway.service.host}")
public interface UserService {
	
	@GetMapping("/authorization/credential")
	public Credential retrieveCredential();
	
}
