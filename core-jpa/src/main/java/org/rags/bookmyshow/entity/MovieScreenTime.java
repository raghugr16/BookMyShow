package org.rags.bookmyshow.entity;

import lombok.Data;
import org.hibernate.annotations.Type;

import java.sql.Time;
import java.util.Date;

import javax.persistence.*;

@Data
@Entity
public class MovieScreenTime extends Root{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Type(type = "org.hibernate.type.UUIDCharType")
	@Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
	private Long movieScreenTimeId;

	private Date audiDate;
	private Time audiStartTime;
	private Time audiEndTime;

	@OneToMany
	private Audi audi;
	private MovieScreenStatus movieScreenStatus;

	public MovieScreenTime() {
	}

	public MovieScreenTime(Date recordTime, boolean isActive, Long movieScreenTimeId, Date audiDate, Time audiStartTime,
						   Time audiEndTime, Audi audi, MovieScreenStatus movieScreenStatus) {
		super(recordTime, isActive);
		this.movieScreenTimeId = movieScreenTimeId;
		this.audiDate = audiDate;
		this.audiStartTime = audiStartTime;
		this.audiEndTime = audiEndTime;
		this.audi = audi;
		this.movieScreenStatus = movieScreenStatus;
	}


	
}
