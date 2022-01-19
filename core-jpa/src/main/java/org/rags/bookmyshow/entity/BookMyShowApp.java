package org.rags.bookmyshow.entity;

import lombok.Data;
import org.hibernate.annotations.Type;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.*;

//@Data
//@Entity
public class BookMyShowApp extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Type(type = "org.hibernate.type.UUIDCharType")
	@Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
	private UUID bookMyShowAppId;

	@OneToMany(mappedBy = "bookMyShowApp")
	@JoinColumn(name = "theaterId")
	private List<Theater> theaterList;

	@OneToMany(mappedBy = "bookMyShowApp")
	@JoinColumn(name = "userId")
	private List<User> userList;

	/*@OneToOne
	@JoinColumn(name = "admin_user_id")
	private AdminUser adminUser;

	@OneToOne
	@JoinColumn(name = "customer_user_id")
	private CustomerUser customerUser;

	@OneToOne
	@JoinColumn(name = "theater_user_id")
	private TheaterUser theaterUser;*/

	public BookMyShowApp() {
	}

	public BookMyShowApp(UUID bookMyShowAppId, List<Theater> theaterList, List<User> userList) {
		this.bookMyShowAppId = bookMyShowAppId;
		this.theaterList = theaterList;
		this.userList = userList;
	}
}
