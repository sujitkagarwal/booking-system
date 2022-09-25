package com.assessment.theater.conversion.cinema;

import com.assessment.theater.entity.cinema.CinemaHall;
import com.assessment.theater.entity.cinema.CinemaSeat;
import com.assessment.theater.model.cinema.CinemaHallRequest;
import com.assessment.theater.model.cinema.SeatRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CinemaHallRequestConversion implements Converter<CinemaHallRequest, CinemaHall> {

    private final Converter<SeatRequest, CinemaSeat> cinemaSeatRequestConverter;

    @Override
    public CinemaHall convert(CinemaHallRequest source) {
        CinemaHall cinemaHall = CinemaHall.builder()
                .name(source.getName())
                .totalNoSeat(source.getTotalNoSeat())
                .build();
        cinemaHall.setCinemaSeat(buildCinemaSeat(source, cinemaHall));
        return cinemaHall;
    }

    private List<CinemaSeat> buildCinemaSeat(CinemaHallRequest source, CinemaHall cinemaHall) {
        return source.getCinemaSeat().stream().map(seatRequest -> {
            CinemaSeat cinemaSeat = cinemaSeatRequestConverter.convert(seatRequest);
            cinemaSeat.setCinemaHall(cinemaHall);
            return cinemaSeat;
        }).collect(Collectors.toList());
    }
}
