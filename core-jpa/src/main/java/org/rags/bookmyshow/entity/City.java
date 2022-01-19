package org.rags.bookmyshow.entity;

import lombok.Data;
import org.hibernate.annotations.Type;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;

import javax.persistence.*;

//@Data
//@Entity
public class City extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Type(type = "org.hibernate.type.UUIDCharType")
	@Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
	private UUID cityId;

	@Embedded
	private Address address;

	@OneToMany(mappedBy = "city")
//	@JoinTable(name = "city_theater",
//				joinColumns = @JoinColumn(columnDefinition = "city_id"),
//				inverseJoinColumns = @JoinColumn(columnDefinition = "theater_id")
//	)
	private Collection<Theater> theaters = new ArrayList<>();

	public City() {
	}

	public City(UUID cityId, Address address, Collection<Theater> theaters) {
		this.cityId = cityId;
		this.address = address;
		this.theaters = theaters;
	}
}
