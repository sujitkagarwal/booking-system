package com.assessment.theater.service.cinema.impl;

import com.assessment.theater.entity.city.City;
import com.assessment.theater.model.city.CityRequest;
import com.assessment.theater.repository.CinemaRepository;
import com.assessment.theater.service.cinema.CinemaService;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CinemaServiceImpl implements CinemaService {

    private final Converter<CityRequest, City> cityConverter;
    private final CinemaRepository cinemaRepository;

    @Override
    public void onboardCinema(CityRequest cityRequest) {
        cinemaRepository.save(cityConverter.convert(cityRequest));
    }
}
