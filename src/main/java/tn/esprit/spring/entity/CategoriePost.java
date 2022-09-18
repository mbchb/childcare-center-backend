package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name="CategoriePost")

public class CategoriePost implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="IdCategoriePost")

	private long idCategoriePost ; 
	@Column(name="label")

	private String label ; 
	@Column(name="Publication")
	@JsonIgnore
	@OneToMany (mappedBy="categoriePublication")
	private Set<Publication> publication ;
}
