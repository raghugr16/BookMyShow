package org.rags.bookmyshow.entity;

import lombok.Data;
import org.hibernate.annotations.Type;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.*;

@Data
@Entity
public class Movie extends Root{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Type(type = "org.hibernate.type.UUIDCharType")
	@Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
	private UUID movieId;

	private String movieName;
	private MovieGenres movieGenres;
	private List<MovieScreenTime> movieScreenTimeList;

	public Movie() {
	}

	public Movie(Date recordTime, boolean isActive, UUID movieId, String movieName, MovieGenres movieGenres, List<MovieScreenTime> movieScreenTimeList) {
		super(recordTime, isActive);
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieGenres = movieGenres;
		this.movieScreenTimeList = movieScreenTimeList;
	}
}
