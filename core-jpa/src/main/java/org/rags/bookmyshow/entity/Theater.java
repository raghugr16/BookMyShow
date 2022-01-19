package org.rags.bookmyshow.entity;

import lombok.Data;
import org.hibernate.annotations.Type;

import java.util.*;

import javax.persistence.*;

//@Data
//@Entity
public class Theater extends BaseEntity {

//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Type(type = "org.hibernate.type.UUIDCharType")
//	@Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
	private UUID theaterId;

	private String theaterName;

//	@Enumerated(EnumType.STRING)
	private TheaterType theaterType;

//	@OneToMany(mappedBy = "theater")
//	@JoinTable( name = "Theater_audi",
//				joinColumns = @JoinColumn(columnDefinition = "theater_id"),
//				inverseJoinColumns = @JoinColumn(columnDefinition = "audi_id"))
//	private Collection<Audi> audiList = new ArrayList<Audi>();

	@ManyToOne
	private BookMyShowApp bookMyShowApp;

	@ManyToOne
	@JoinColumn(columnDefinition = "city_id")
	private City city;

	public Theater() {
	}

	public Theater(UUID theaterId, String theaterName, TheaterType theaterType, List<Audi> audiList, City city) {
		this.theaterId = theaterId;
		this.theaterName = theaterName;
		this.theaterType = theaterType;
		this.audiList = audiList;
		this.city = city;
	}
}
