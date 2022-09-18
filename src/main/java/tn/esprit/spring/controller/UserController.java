package tn.esprit.spring.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import tn.esprit.spring.Iservice.IUserService;
import tn.esprit.spring.entity.User;

@RequestMapping("/users")
@RestController
public class UserController {
	@Autowired
	IUserService userService;

	@GetMapping("/listuser")
	@ResponseBody
	public ResponseEntity<List<User>> getUser() {
		return ResponseEntity.ok().body(userService.retrieveAll());
	}

	@PostMapping("/adduser")
	@ResponseBody
	public ResponseEntity<User> addUser(@RequestBody User user) {
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/user/adduser").toUriString());
		return ResponseEntity.created(uri).body(userService.addUser(user));
	}

	@PutMapping("/updateUser")
	@ResponseBody
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		return ResponseEntity.ok().body(userService.updateUser(user));
	}

	@DeleteMapping("/deleteUser/{IdUser}")
	@ResponseBody
	public ResponseEntity<Void> deleteUser(@PathVariable("IdUser") long IdUser) {
		userService.deleteUser(IdUser);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/getUser/{username}")
	@ResponseBody
	public ResponseEntity<User> getUser(@PathVariable("username") String username) {
		return ResponseEntity.ok().body(userService.getUser(username));
	}

	@GetMapping("/search")
	public ResponseEntity<List<User>> retrieveTransporteurByNom(@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("idRole") Integer idRole) {
		return ResponseEntity.ok().body(userService.search(firstName, lastName, idRole));
	}
}
