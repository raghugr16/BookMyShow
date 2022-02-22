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
public class Audi extends BaseEntity {

	public Audi(){
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Type(type = "org.hibernate.type.UUIDCharType")
	@Column(name = "audiId", length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
	private UUID audiId;

	private String audiName;

	@Enumerated(EnumType.STRING)
	private AudiSize audiSize;

	@Enumerated(EnumType.STRING)
	private AudiType audiType;

	private Integer no_of_seats;

	@OneToMany(mappedBy = "audi",cascade = CascadeType.ALL)
	private List<Seat> seatList;

	@ManyToOne
	@JoinTable( name = "theater_audi",
			joinColumns = @JoinColumn(name = "audiId", referencedColumnName = "audiId"),
			inverseJoinColumns = @JoinColumn(name = "theaterId", referencedColumnName = "theaterId"))
	private Theater theater;

	@OneToMany(mappedBy = "audi" , cascade = CascadeType.ALL)
	private List<MovieScreen> movieScreenTimes = new ArrayList<>();
}
