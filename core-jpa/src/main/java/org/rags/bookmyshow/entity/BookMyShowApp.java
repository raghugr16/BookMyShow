package org.rags.bookmyshow.entity;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@SuperBuilder
public class BookMyShowApp extends BaseEntity {

	public BookMyShowApp() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Type(type = "org.hibernate.type.UUIDCharType")
	@Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
	private UUID bookMyShowAppId;

	@OneToMany(mappedBy = "bookMyShowApp", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Collection<Theater> theaterList = new ArrayList<>();

	@OneToMany(mappedBy = "bookMyShowApp", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Collection<TheaterUser> theaterUsers = new ArrayList<>();

	@OneToMany(mappedBy = "bookMyShowApp", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Collection<CustomerUser> customerUsers = new ArrayList<>();

	@OneToMany(mappedBy = "bookMyShowApp", cascade = CascadeType.ALL)
	private List<AdminUser> adminUsers = new ArrayList<>();

}
