package org.rags.bookmyshow.entity;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@SuperBuilder
public class AdminUser extends User{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Type(type = "org.hibernate.type.UUIDCharType")
	@Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
	private UUID adminId;


	@ManyToOne()
	@JoinColumn(name = "book_my_show_id")
	private BookMyShowApp bookMyShowApp;

	public AdminUser(){
		super();
	}

	public AdminUser(String userName, String email, String phoneNumber, UUID adminId, BookMyShowApp bookMyShowApp) {
		super(userName, email, phoneNumber);
		this.adminId = adminId;
		this.bookMyShowApp = bookMyShowApp;
	}
}
