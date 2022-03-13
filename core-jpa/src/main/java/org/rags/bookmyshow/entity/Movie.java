package org.rags.bookmyshow.entity;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
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

	@OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<MovieScreen> movieScreenTimes = new ArrayList<MovieScreen>();
}
