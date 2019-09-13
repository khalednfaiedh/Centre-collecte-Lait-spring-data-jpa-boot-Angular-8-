package com.spark.collecteLait.Rest.Dto;

 

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

 
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {
 
	private Long id;
    private String password;
	private String role;
	private String permission;
	

}
