package com.example.demo;

import java.util.Map;

import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.stereotype.Component;

@Component
public class ZipkinPrincipalExtractor implements PrincipalExtractor {
	@Override
	public Object extractPrincipal(Map<String, Object> map) {
		return map.get("login");
	}
}