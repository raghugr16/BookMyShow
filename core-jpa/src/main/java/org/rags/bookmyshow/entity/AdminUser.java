package org.rags.bookmyshow.entity;

import lombok.Data;
import org.hibernate.annotations.Type;

import java.awt.print.Book;
import java.util.Date;
import java.util.UUID;

import javax.persistence.*;

//@Data
//@Entity
public class AdminUser extends User{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Type(type = "org.hibernate.type.UUIDCharType")
	@Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
	private UUID adminId;
	private String password;



	public AdminUser(){
	}

	public AdminUser(String userName, String emaill, String phonenumber, UUID adminId, String password) {
		super(userName, emaill, phonenumber);
		this.adminId = adminId;
		this.password = password;
	}
}
