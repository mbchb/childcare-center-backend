package tn.esprit.spring.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import tn.esprit.spring.Iservice.IUserService;
import tn.esprit.spring.entity.User;

@RequestMapping("/auth")
@RestController
public class AuthController {
	
	@Autowired
	IUserService userService;

	@PostMapping("/signup")
	@ResponseBody
	public ResponseEntity<User> signup(@RequestBody User user) {
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/auth/signup").toUriString());
		return ResponseEntity.created(uri).body(userService.addUser(user));
	}
}
