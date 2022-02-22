package org.rags.bookmyshow.entity;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@SuperBuilder
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "org.hibernate.type.UUIDCharType")
    @Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
    private UUID audiClassId;

    private SeatClassType seatClassType;

    private Integer seatColumn;

    private String seatName;

    private SeatType seatType;

    private SeatStatus seatStatus;

    @ManyToOne()
    @JoinColumn(name = "audi_id", nullable = false)
    private Audi audi;

    public Seat() {
    }

    public Seat(UUID audiClassId, SeatClassType seatClassType, Integer seatColumn, String seatName, SeatType seatType, SeatStatus seatStatus) {
        this.audiClassId = audiClassId;
        this.seatClassType = seatClassType;
        this.seatColumn = seatColumn;
        this.seatName = seatName;
        this.seatType = seatType;
        this.seatStatus = seatStatus;
    }
}
