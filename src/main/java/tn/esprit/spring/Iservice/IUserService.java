package tn.esprit.spring.Iservice;

import java.util.List;

import tn.esprit.spring.entity.User;

public interface IUserService {

	User addUser(User u);

	User getUser(String userName);

	User updateUser(User u);

	List<User> retrieveAll();

	void deleteUser(Long IdUser);

	List<User> search(String firstName, String lastName, Integer idRole);
}