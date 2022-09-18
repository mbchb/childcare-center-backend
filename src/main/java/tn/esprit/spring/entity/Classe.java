package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name="Classe")
public class Classe implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idClasse")

    private int idClasse ; 
	@Column(name="label")

	private String label ; 
	@Column(name="Enfants")

	@OneToMany (mappedBy="classe")
	private Set<Enfants> enfants ;
	//@Column(name="Employe")

	@OneToMany (mappedBy="classe")
	private Set<Employe> employe ;
	//@Column(name="Jardin")

	@ManyToOne(cascade = CascadeType.ALL)
	private User jardin ;
	
	
}
