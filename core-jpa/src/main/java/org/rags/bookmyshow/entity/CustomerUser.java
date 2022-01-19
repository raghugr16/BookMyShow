package org.rags.bookmyshow.entity;

import lombok.Data;
import org.hibernate.annotations.Type;

import java.util.Date;
import java.util.UUID;

import javax.persistence.*;

@Data
@Entity
public class CustomerUser extends User{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Type(type = "org.hibernate.type.UUIDCharType")
	@Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
	private UUID customerId;

	private String password;

	@ManyToOne()
	@JoinColumn(name = "book_my_show_id")
	private BookMyShowApp bookMyShowApp;

	public CustomerUser() {
	}

	public CustomerUser(String userName, String email, String phoneNumber, String password) {
		super(userName, email, phoneNumber);
		this.password = password;
	}
}
