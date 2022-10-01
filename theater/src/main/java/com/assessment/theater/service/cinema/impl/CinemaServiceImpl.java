package com.assessment.theater.service.cinema.impl;

import com.assessment.theater.entity.city.City;
import com.assessment.theater.model.city.CityRequest;
import com.assessment.theater.repository.city.CityRepository;
import com.assessment.theater.service.cinema.CinemaService;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@AllArgsConstructor
public class CinemaServiceImpl implements CinemaService {

    private final Converter<CityRequest, City> cityConverter;
    private final CityRepository cityRepository;

    @Override
    public CompletableFuture<Void> onboardCinema(CityRequest cityRequest) {
        return CompletableFuture.runAsync(() -> cityRepository.save(cityConverter.convert(cityRequest)));
    }
}
