package org.rags.bookmyshow.entity;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

@Data
@Entity
@SuperBuilder
public class Movie extends BaseEntity {

	public Movie() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Type(type = "org.hibernate.type.UUIDCharType")
	@Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
	private UUID movieId;

	private String movieName;

	@Enumerated(EnumType.STRING)
	private MovieGenres movieGenres;

	@OneToMany(mappedBy = "movie")
	private Collection<MovieScreenTime> movieScreenTimes = new ArrayList<MovieScreenTime>();
}
