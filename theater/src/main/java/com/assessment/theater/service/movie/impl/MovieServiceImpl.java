package com.assessment.theater.service.movie.impl;

import com.assessment.theater.entity.movie.Movie;
import com.assessment.theater.model.movie.MovieRequest;
import com.assessment.theater.repository.MovieRepository;
import com.assessment.theater.service.movie.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MovieServiceImpl implements MovieService {

    private final Converter<MovieRequest, Movie> converter;
    private final MovieRepository movieRepository;
    @Override
    public void addMovie(MovieRequest movieRequest) {
        movieRepository.save(converter.convert(movieRequest));
    }
}
