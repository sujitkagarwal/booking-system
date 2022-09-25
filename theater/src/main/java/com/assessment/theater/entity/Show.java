package com.assessment.theater.entity;

import com.assessment.theater.entity.cinema.CinemaHall;
import com.assessment.theater.entity.movie.Movie;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@Builder(toBuilder = true)
@Entity
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    private LocalDate date;

    private LocalTime  startTime;

    private LocalTime  endTime;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "show")
    private List<ShowSeat> showSeats;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cinemaHall_id")
    private CinemaHall cinemaHall;





}
