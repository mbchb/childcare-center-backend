package tn.esprit.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import tn.esprit.spring.Iservice.IRoleService;
import tn.esprit.spring.entity.Role;
import tn.esprit.spring.repository.RoleRepository;

@Service @RequiredArgsConstructor
public class RoleService implements IRoleService {
	
	private final RoleRepository roleRepository;

	@Override
	public List<Role> retrieveAll() {
		return roleRepository.findAll();
	}
}
