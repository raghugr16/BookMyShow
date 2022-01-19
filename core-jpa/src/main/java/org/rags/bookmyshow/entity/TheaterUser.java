package org.rags.bookmyshow.entity;

import lombok.Data;
import org.hibernate.annotations.Type;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;

import javax.persistence.*;

@Data
@Entity
public class TheaterUser extends User{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Type(type = "org.hibernate.type.UUIDCharType")
	@Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
	private UUID theaterId;

	private String password;


	@ManyToOne()
	@JoinColumn(name = "book_my_show_id",referencedColumnName = "bookMyShowAppId")
	private BookMyShowApp bookMyShowApp;

	public TheaterUser() {
	}

	public TheaterUser(String userName, String email, String phoneNumber, String password) {
		super(userName, email, phoneNumber);
		this.password = password;
	}
}
