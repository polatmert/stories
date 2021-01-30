package com.stories.ws.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.stories.ws.shared.Views;

import lombok.Data;
 
@Data
@Entity
public class User {
	
	@Id
	@GeneratedValue
	private long id;
	
	@NotNull(message="{stories.constraint.username.NotNull.message}")
	@Size(min=4, max=64)
	//@Column(unique = true)
	@UniqueUsername
	@JsonView(Views.Base.class)
	private String username;
	
	@NotNull
	@Size(min=4, max=64)
	@JsonView(Views.Base.class)
	private String displayName;
	
	@NotNull
	@Size(min=8, max=64)
	//@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$" , message="{stories.constraint.password.Pattern.message}")
	private String password;
	
	@JsonView(Views.Base.class)
	private String image;
	
}