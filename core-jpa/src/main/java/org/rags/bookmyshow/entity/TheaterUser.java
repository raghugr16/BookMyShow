package org.rags.bookmyshow.entity;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@SuperBuilder
public class TheaterUser extends User{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Type(type = "org.hibernate.type.UUIDCharType")
	@Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
	private UUID theaterId;

	@ManyToOne()
	@JoinColumn(name = "book_my_show_id",referencedColumnName = "bookMyShowAppId")
	private BookMyShowApp bookMyShowApp;

	public TheaterUser() {
	}

	public TheaterUser(String userName, String email, String phoneNumber, UUID theaterId, BookMyShowApp bookMyShowApp) {
		super(userName, email, phoneNumber);
		this.theaterId = theaterId;
		this.bookMyShowApp = bookMyShowApp;
	}
}
