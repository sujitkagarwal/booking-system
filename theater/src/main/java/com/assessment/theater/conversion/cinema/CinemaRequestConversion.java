package com.assessment.theater.conversion.cinema;

import com.assessment.theater.entity.cinema.Cinema;
import com.assessment.theater.entity.cinema.CinemaHall;
import com.assessment.theater.model.cinema.CinemaHallRequest;
import com.assessment.theater.model.cinema.CinemaRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CinemaRequestConversion implements Converter<CinemaRequest, Cinema> {

   private final Converter<CinemaHallRequest, CinemaHall> cinemaRequestConverter;

    @Override
    public Cinema convert(CinemaRequest cinemaRequest) {
        Cinema cinema = Cinema.builder()
                .name(cinemaRequest.getName())
                .build();
         List<CinemaHall> cinemaHalls = buildCinemaHall(cinemaRequest, cinema);
        cinema.setCinemaHalls(cinemaHalls);
        return cinema;
    }

    private List<CinemaHall> buildCinemaHall(CinemaRequest cinemaRequest,final Cinema cinema) {
        return cinemaRequest.getCinemaHalls().stream().map(cinemaHallRequest -> {
            CinemaHall cinemaHall = cinemaRequestConverter.convert(cinemaHallRequest);
            cinemaHall.setCinema(cinema);
            return cinemaHall;
        }).collect(Collectors.toList());

    }
}
