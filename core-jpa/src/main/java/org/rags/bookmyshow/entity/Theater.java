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
public class Theater extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Type(type = "org.hibernate.type.UUIDCharType")
	@Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
	private UUID theaterId;

	private String theaterName;

	@Enumerated(EnumType.STRING)
	private TheaterType theaterType;

	@OneToMany(mappedBy = "theater", cascade = CascadeType.ALL)
	private Collection<Audi> audiList = new ArrayList<Audi>();

	@ManyToOne
	@JoinTable(name = "book_my_show_theater",
			joinColumns = @JoinColumn(name = "theater_id", referencedColumnName = "theaterId"),
			inverseJoinColumns = @JoinColumn(name = "book_my_show_app_Id", referencedColumnName = "bookMyShowAppId")
	)
	private BookMyShowApp bookMyShowApp;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "city_theater",
			joinColumns = @JoinColumn(name = "theater_id", referencedColumnName = "theaterId"),
			inverseJoinColumns = @JoinColumn(name = "city_id", referencedColumnName = "cityId")
	)
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
