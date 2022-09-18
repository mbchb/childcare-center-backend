package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.Iservice.IRoleService;
import tn.esprit.spring.entity.Role;

@RequestMapping("/roles")
@RestController
public class RoleController {
	@Autowired
	IRoleService roleService;

	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Role>> getRoles() {
		System.out.println("contr role");
		return ResponseEntity.ok().body(roleService.retrieveAll());
	}

	
}
