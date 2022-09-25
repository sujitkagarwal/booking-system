package com.assessment.theater.conversion.city;

import com.assessment.theater.entity.cinema.Cinema;
import com.assessment.theater.entity.city.City;
import com.assessment.theater.model.cinema.CinemaRequest;
import com.assessment.theater.model.city.CityRequest;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class CityRequestConversion implements Converter<CityRequest, City> {
    private final Converter<CinemaRequest, Cinema> cinemaRequestConverter;

    @Override
    public City convert(CityRequest cityRequest) {
        City city = City.builder()
                .name(cityRequest.getName())
                .state(cityRequest.getState())
                .zipCode(cityRequest.getZipCode())
                .build();

        List<Cinema> cinemas = buildCinemaHall(cityRequest, city);
        city.setCinema(cinemas);
        return city;
    }

    private List<Cinema> buildCinemaHall(CityRequest cityRequest, final City city) {
        List<Cinema> collect = cityRequest.getCinemaRequests().stream().map(cinemaRequest -> {
            Cinema cinema = cinemaRequestConverter.convert(cinemaRequest);
            cinema.setCity(city);
            return cinema;
        }).collect(Collectors.toList());
        return collect;
    }

}
