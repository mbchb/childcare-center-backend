package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.UniqueConstraint;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@NoArgsConstructor
@Table(	name = "user", 
uniqueConstraints = { 
	@UniqueConstraint(columnNames = "username"),
	@UniqueConstraint(columnNames = "email") 
})
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_user")
	private Long idUser ; 
	
	@Column(name="lastname")
	private String lastName ;
	
	@Column(name="firstname")
	private String firstName ;
	
	@NotBlank
	@Size(max = 20)
	@Column(name="username")
	private String username;
	
	@NotBlank
	@Size(max = 50)
	@Email
	@Column(name="email")
	private String email ; 
	
	@Column(name="password")
	private String password ; 
	
	@Column(name="description")
	private String description ; 
	
	@Column(name="nbrEmployee")
	private int  nbrEmploye ;
	
	@Column(name="phone")
	private int phoneNumber ; 
	
	@Column(name="localisation")
	private String localisation ; 
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(	name = "user_roles", 
				joinColumns = @JoinColumn(name = "id_user"), 
				inverseJoinColumns = @JoinColumn(name = "id_role"))
	private Set<Role> roles = new HashSet<>();

	public User(Long idUser, String lastName, String firstName, @NotBlank @Size(max = 20) String username,
			@NotBlank @Size(max = 50) @Email String email, String password, String description, int nbrEmploye,
			int phoneNumber, String localisation) {
		super();
		this.idUser = idUser;
		this.lastName = lastName;
		this.firstName = firstName;
		this.username = username;
		this.email = email;
		this.password = password;
		this.description = description;
		this.nbrEmploye = nbrEmploye;
		this.phoneNumber = phoneNumber;
		this.localisation = localisation;
	}
	
	public User(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}

	@OneToMany (mappedBy="user")
	private Set<Enfants> enfants ;
	
	
	@OneToMany (mappedBy="user")
	private Set<Rendezvous> rendezvous ;
	
	@OneToMany (mappedBy="user")
	private Set<Publication> publication ; 
	
	@OneToMany (mappedBy="jardin")
	private Set<Classe> classe ;
	
	@OneToMany (mappedBy="jardin")
	private Set<Employe> employe ;
	
	@OneToMany (mappedBy="user")
	private Set<Reclamation> reclamation ;
}

