package org.rags.bookmyshow.entity;

import lombok.Data;
import org.hibernate.annotations.Type;

import java.util.*;

import javax.persistence.*;

@Data
@Entity
public class Audi extends BaseEntity {

	public Audi(){
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
	@JoinTable( name = "theater_audi",
			joinColumns = @JoinColumn(name = "audiId", referencedColumnName = "audiId"),
			inverseJoinColumns = @JoinColumn(name = "theaterId", referencedColumnName = "theaterId"))
	private Theater theater;

	@OneToMany(mappedBy = "audi")
	private Collection<MovieScreenTime> movieScreenTimes = new ArrayList<>();
}
