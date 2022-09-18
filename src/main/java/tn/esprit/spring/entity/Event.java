package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
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
@Table(name="Event")
public class Event implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idEvent")

	private int idEvent ;
	@Column(name="Nom")

	private String Nom ; 
	@Column(name="Date")

	private Date dateEvent ; 
	@Column(name="NbrInscri")

	private int nbrInscri ; 
	//@Column(name="CategorieEvent")

	@ManyToOne(cascade = CascadeType.ALL)
	private CategorieEvent categorieEvent ;
}
