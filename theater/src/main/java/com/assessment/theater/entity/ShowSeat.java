package com.assessment.theater.entity;

import com.assessment.theater.entity.cinema.CinemaSeat;
import com.assessment.theater.entity.cinema.SeatStatus;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Builder(toBuilder = true)
@Entity
public class ShowSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    private SeatStatus status;

    private Float price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cinemaSeat_id")
    private CinemaSeat cinemaSeat;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "show_id")
    private Show show;





}
