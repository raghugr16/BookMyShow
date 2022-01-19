package org.rags.bookmyshow.entity;

import lombok.Data;
import org.hibernate.annotations.Type;

import java.util.*;

import javax.persistence.*;

//@Data
//@Entity
public class Audi extends BaseEntity {

	public Audi(){
	}

	public Audi(UUID audiId, String audiName, AudiSize audiSize, AudiType audiType, Theater theater) {
		this.audiId = audiId;
		this.audiName = audiName;
		this.audiSize = audiSize;
		this.audiType = audiType;
		this.theater = theater;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Type(type = "org.hibernate.type.UUIDCharType")
	@Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
	private UUID audiId;

	private String audiName;

	@Enumerated(EnumType.STRING)
	private AudiSize audiSize;

	@Enumerated(EnumType.STRING)
	private AudiType audiType;

	@ManyToOne
	private Theater theater;

	@OneToMany(mappedBy = "audi")
	@JoinTable(name = "Audi_Movie_Screening",
	joinColumns = @JoinColumn(name = "audi_id"),
	inverseJoinColumns = @JoinColumn(name = "movie_screen_id"))
	private Collection<MovieScreenTime> movieScreenTimes = new ArrayList<>();
}
