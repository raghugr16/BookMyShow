package org.rags.bookmyshow.entity;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;


@MappedSuperclass
@Data
public abstract class User extends BaseEntity {

	private String userName;
	private String email;
	private String phoneNumber;

	private UserType userType;

	public User(){
	}

	public User(String userName, String email, String phoneNumber) {
		this.userName = userName;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
}
