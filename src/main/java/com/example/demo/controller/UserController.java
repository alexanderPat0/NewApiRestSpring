package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/login")
	public com.example.demo.entity.User login(@RequestParam("user") String username, @RequestParam("password") String password){
		Authentication authentication = authenticationManager.authenticate(
			new UsernamePasswordAuthenticationToken(username, password));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		com.example.demo.entity.User usuario = userService.findUsuario(username);
		String token = getJHTToken(username);
		usuario.setToken(token);
		return usuario;
	}
	
	@PostMapping("/register")
	public com.example.demo.entity.User saveUser(@RequestBody com.example.demo.entity.User user){
		return userService.registrar(user);
	}

	private String getJHTToken(String username) {
		return null;
	}
}
