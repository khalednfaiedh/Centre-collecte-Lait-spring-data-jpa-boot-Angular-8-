package com.spark.collecteLait.model.entity;

import java.io.Serializable;
 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

 
 

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name="USER1")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User   implements Serializable {
	private static final long serialVersionUID = 3453965369444836064L;

	@Column(name="ID")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)  
	private Long id;
	
	@Column(name="password")
    private String password;
	
	@Column(name="role")
	private String role;
	
	@Column(name="permmission ")
	private String permission;
	
}
