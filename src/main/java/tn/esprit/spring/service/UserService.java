package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import tn.esprit.spring.Iservice.IUserService;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.UserRepository;

@Service @RequiredArgsConstructor
public class UserService implements IUserService, UserDetailsService {
	
	private final UserRepository userRepository;
	
	private final PasswordEncoder passwordEncoder;
	
	@Override
	public User addUser(User u) {
		u.setPassword(passwordEncoder.encode(u.getPassword()));
		return userRepository.save(u);
	}

	@Override
	public User updateUser(User u) {
		User User = userRepository.findById((long) u.getIdUser()).get();
		User.setLastName(u.getLastName());
		User.setFirstName(u.getFirstName());
		return userRepository.save(u);
	}

	@Override
	public List<User> retrieveAll() {
		return userRepository.findAll();
	}

	@Override
	public void deleteUser(Long IdUser) {
		Optional<User> User = userRepository.findById(IdUser);
		if (User.isPresent()) {
			userRepository.deleteById(IdUser);
		} else {
			System.out.println(" Il n'ya pas cet utilisateur");

		}
	}
	
	@Override
	public User getUser(String userName) {
		return userRepository.findByUsername(userName);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found in the database");
		}
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
		user.getRoles().forEach(role -> {
			authorities.add(new SimpleGrantedAuthority(role.getName().toString()));
		});
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				authorities);
	}
	
	@Override
	public List<User> search(String firstName, String lastName, Integer idRole) {
		return userRepository.search(firstName, lastName, idRole);
	}
}
