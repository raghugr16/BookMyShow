package org.rags.bookmyshow.entity;

import lombok.Data;
import org.hibernate.annotations.Type;

import java.sql.Time;
import java.util.Date;
import java.util.UUID;

import javax.persistence.*;

@Data
@Entity
public class MovieScreenTime extends BaseEntity {

	public MovieScreenTime() {
	}

	public MovieScreenTime(Movie movie, Date audiDate, Time audiStartTime, Time audiEndTime, MovieScreenStatus movieScreenStatus) {
		this.movie = movie;
		this.audiDate = audiDate;
		this.audiStartTime = audiStartTime;
		this.audiEndTime = audiEndTime;
		this.movieScreenStatus = movieScreenStatus;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Type(type = "org.hibernate.type.UUIDCharType")
	@Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
	private UUID movieScreenTimeId;

	@ManyToOne
	@JoinTable(name = "present_movie_screen",
			joinColumns = @JoinColumn(name = "movie_screen_id"),
			inverseJoinColumns = @JoinColumn(name = "movie_id")
	)
	private Movie movie;

	private Date audiDate;
	private Time audiStartTime;
	private Time audiEndTime;
	private String movie_screen_time;

	@ManyToOne
	@JoinTable(name = "audi_movie_screening",
			joinColumns = @JoinColumn(name = "movie_screen_time_Id", referencedColumnName = "movieScreenTimeId"),
			inverseJoinColumns = @JoinColumn(name = "audi_id",referencedColumnName = "audiId"))
	private Audi audi;

	@Enumerated(EnumType.STRING)
	private MovieScreenStatus movieScreenStatus;
}
