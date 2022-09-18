package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@NoArgsConstructor
@Table(name="Employee")
public class Employe  implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idEmployee")
		private int idEmploye ;
	@Column(name="Nom")
		private String nom ;
	@Column(name="Prenom")
		private String prenom ;
	@Column(name="Tel")
		private int tel ; 
	@Column(name="Email")
		private String email ;
	//@Column(name="Jardin")
		@ManyToOne(cascade = CascadeType.ALL)
		private User jardin ;
	//@Column(name="Classe")
	@ManyToOne(cascade = CascadeType.ALL)
		private Classe classe ;
		

		
}
