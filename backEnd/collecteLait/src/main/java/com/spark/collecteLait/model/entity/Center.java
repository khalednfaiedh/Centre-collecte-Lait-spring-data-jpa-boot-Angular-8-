package com.spark.collecteLait.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CENTER")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Center implements Serializable {

	private static final long serialVersionUID = 3453965369444836064L;
	@Column(name = "ID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nom")
	private String nom;

	@Column(name = "capacite")
	private Long capacite;

	@Column(name = "dateCreation")
	private Date dateCreation;

	@Column(name = "pays")
	private String pays;

	@Column(name = "ville")
	private String ville;

	@Column(name = "codePostal")
	private Long codePostal;

	@Column(name = "rue")
	private String rue;
	
	@OneToMany(mappedBy = "center", cascade = CascadeType.ALL)
    private  List<Agriculteur> agriculteurs;
	

}
