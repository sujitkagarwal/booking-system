package com.assessment.theater.entity.cinema;


import com.assessment.theater.entity.Show;
import lombok.*;

import javax.persistence.*;
import java.util.List;


@Data
@Builder(toBuilder = true)
@EqualsAndHashCode
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CinemaHall {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "total_number_seat")
    private Integer totalNoSeat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cinema_id")
    private Cinema cinema;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cinemaHall",cascade = CascadeType.PERSIST)
    private List<CinemaSeat> cinemaSeat;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cinemaHall",cascade = CascadeType.PERSIST)
    private List<Show> shows;

}
