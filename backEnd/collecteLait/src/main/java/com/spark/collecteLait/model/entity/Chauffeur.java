package com.spark.collecteLait.model.entity;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "chauffeur")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Chauffeur implements Serializable {

	private static final long serialVersionUID = 3453965369444836064L;

	@Column(name = "ID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "cin")
	private String cin;

	@Column(name = "nom")
	private String nom;

	@Column(name = "prenom")
	private String prenom;

	@Column(name = "dateNaissance")
	private Date dateNaissance;

	@Column(name = "address")
	private String address;

	@Column(name = "phone")
	private  Long phone;

	@Column(name = "email")
	private String email;

	@ManyToOne
	@JoinColumn(name = "idCenter")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Center center;

}
