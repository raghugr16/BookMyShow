package org.rags.bookmyshow.entity;

import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Data
public abstract class User extends BaseEntity {
	
	private String userName;
	private String email;
	private String phoneNumber;

	private UserType userType;

	@ManyToOne()
	private BookMyShowApp bookMyShowApp;

	public User(){
	}

	public User(String userName, String email, String phoneNumber) {
		this.userName = userName;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
}
