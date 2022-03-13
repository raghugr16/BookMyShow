package org.rags.bookmyshow.entity;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@SuperBuilder
public class MovieScreen extends BaseEntity {

	public MovieScreen() {
	}

	public MovieScreen(UUID movieScreenTimeId, Movie movie, Date audiDate, Time audiStartTime, Time audiEndTime, String movieScreenTable, Audi audi, ScreenStatus screenStatus) {
		this.movieScreenTimeId = movieScreenTimeId;
		this.movie = movie;
		this.audiDate = audiDate;
		this.audiStartTime = audiStartTime;
		this.audiEndTime = audiEndTime;
		this.movieScreenTable = movieScreenTable;
		this.audi = audi;
		this.screenStatus = screenStatus;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Type(type = "org.hibernate.type.UUIDCharType")
	@Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
	private UUID movieScreenTimeId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinTable(name = "present_movie_screen",
			joinColumns = @JoinColumn(name = "movie_screen_id"),
			inverseJoinColumns = @JoinColumn(name = "movie_id")
	)
	private Movie movie;

	private Date audiDate;
	private Time audiStartTime;
	private Time audiEndTime;
	private String movieScreenTable;
	private String movieScreenShortName;

	@ManyToOne()
	@JoinTable(name = "audi_movie_screening",
			joinColumns = @JoinColumn(name = "movie_screen_time_Id", referencedColumnName = "movieScreenTimeId"),
			inverseJoinColumns = @JoinColumn(name = "audi_id",referencedColumnName = "audiId"))
	private Audi audi;

	@Enumerated(EnumType.STRING)
	private ScreenStatus screenStatus;
}
