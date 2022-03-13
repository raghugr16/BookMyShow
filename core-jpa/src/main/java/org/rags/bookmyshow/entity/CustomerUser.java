package org.rags.bookmyshow.entity;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@SuperBuilder
public class CustomerUser extends User{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Type(type = "org.hibernate.type.UUIDCharType")
	@Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
	private UUID customerId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "book_my_show_id")
	private BookMyShowApp bookMyShowApp;

	public CustomerUser() {
	}

	public CustomerUser(String userName, String email, String phoneNumber, UUID customerId, BookMyShowApp bookMyShowApp) {
		super(userName, email, phoneNumber);
		this.customerId = customerId;
		this.bookMyShowApp = bookMyShowApp;
	}
}
