package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name="Publication")
public class Publication  implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idPost")

	private long idPost  ; 
	
	@Column(name="Contenue")

	private String contenue ; 
	@Column(name="Commentaire")

	private String commentaire ; 
	@Column(name="Interraction")

	private Boolean interraction ;
	@Column(name="Image")

	private String image ;
	
	//@Column(name="CategoriePublication")
    @JsonIgnore

	@ManyToOne(fetch= FetchType.LAZY)
	private CategoriePost categoriePublication ;
    @JsonIgnore

	@ManyToOne(fetch= FetchType.LAZY)
	private User user ;
	

}
