package com.spark.collecteLait.Rest.Dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.spark.collecteLait.model.entity.Agriculteur;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CenterDto {

	private Long id;

	private String nom;

	private Long capacite;

	private Date dateCreation;

	private String pays;

	private String ville;

	private Long codePostal;

	private String rue;
	
	 

}
