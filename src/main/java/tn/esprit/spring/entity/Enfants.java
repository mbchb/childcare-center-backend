package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@NoArgsConstructor
@Table(name="Enfants")
public class Enfants  implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idEnfants")

	private int idEnfants ; 
	@Column(name="Nom")

	private String nom ;
	@Column(name="Prenom")

	private String prenom ; 
	@Column(name="Age")

	private int age ; 
	//@Column(name="Classe")

	@ManyToOne(cascade = CascadeType.ALL)
	private Classe classe ;
	//@Column(name="User")

	@ManyToOne(cascade = CascadeType.ALL)
	private User user ;
}
