package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
	
	@Query(value="SELECT u.* FROM user u WHERE u.firstName LIKE %:firstName% AND u.lastName LIKE %:lastName% "
			+ " AND u.id_user IN (SELECT ur.id_user FROM user_roles ur WHERE ur.id_role = :idRole )", nativeQuery = true)
	List<User> search(@Param("firstName") String firstName, @Param("lastName") String lastName,
			@Param("idRole") Integer idRole);
}
