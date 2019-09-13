package com.spark.collecteLait.Rest.Dto;

 

 

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ChauffeurDto {

	private Long id;

	private Long codeCnss;
	
	private String cin;

	private String nom;

	private String prenom;

	private Date dateNaissance;

	private String address;

	private  Long phone;

	private String email;
}
