package com.assessment.theater.model.cinema;

import com.assessment.theater.entity.cinema.SeatType;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class SeatRequest {

    private final Integer seatNumber;

    private final SeatType seatType;
}
