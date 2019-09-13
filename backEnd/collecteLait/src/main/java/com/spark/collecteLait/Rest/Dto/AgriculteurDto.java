package com.spark.collecteLait.Rest.Dto;

import java.sql.Blob;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.spark.collecteLait.model.entity.Center;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgriculteurDto {

	private Long id;

	private Long code;

	private String cin;

	private String prenom;

	private String address;

	private String phone;

	private String email;

	private String nom;

	private Date dateNaissance;

	private Blob image;

}
