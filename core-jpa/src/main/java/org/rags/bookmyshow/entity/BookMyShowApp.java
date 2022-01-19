package org.rags.bookmyshow.entity;

import lombok.Data;
import org.hibernate.annotations.Type;

import java.util.*;

import javax.persistence.*;

@Data
@Entity
public class BookMyShowApp extends BaseEntity {

	public BookMyShowApp() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Type(type = "org.hibernate.type.UUIDCharType")
	@Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
	private UUID bookMyShowAppId;

	@OneToMany(mappedBy = "bookMyShowApp")
	private List<Theater> theaterList;

	@OneToMany(mappedBy = "bookMyShowApp")
	private Collection<TheaterUser> theaterUsers = new ArrayList<>();

	@OneToMany(mappedBy = "bookMyShowApp")
	private Collection<CustomerUser> customerUsers = new ArrayList<>();

	@OneToMany(mappedBy = "bookMyShowApp")
	private Collection<AdminUser> adminUsers = new ArrayList<>();

}
