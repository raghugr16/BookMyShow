package org.rags.bookmyshow.entity;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import javax.persistence.MappedSuperclass;


@MappedSuperclass
@Data
@SuperBuilder
public abstract class User extends BaseEntity {

	private String userName;
	private String email;
	private String password;
	private String phoneNumber;

	private UserType userType;

	public User(){
		super();
	}

	public User(String userName, String email, String phoneNumber) {
		this.userName = userName;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
}
