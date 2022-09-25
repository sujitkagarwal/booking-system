package com.assessment.theater.entity.cinema;


import com.assessment.theater.entity.ShowSeat;
import lombok.*;

import javax.persistence.*;
import java.util.List;


@Data
@Builder(toBuilder = true)
@EqualsAndHashCode
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CinemaSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "seat_number")
    private Integer seatNumber;

    @Column(name = "seat_type")
    private SeatType seatType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cinemaHall_id")
    private CinemaHall cinemaHall;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cinemaSeat")
    private List<ShowSeat> showSeats;


}
