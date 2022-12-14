package com.assessment.theater.service.movie.impl;

import com.assessment.theater.entity.movie.Movie;
import com.assessment.theater.model.movie.MovieRequest;
import com.assessment.theater.repository.movie.MovieRepository;
import com.assessment.theater.service.movie.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@RequiredArgsConstructor
@Component
public class MovieServiceImpl implements MovieService {

    private final Converter<MovieRequest, Movie> converter;
    private final MovieRepository movieRepository;

    @Override
    public CompletableFuture<Void> addMovie(MovieRequest movieRequest) {
        return CompletableFuture.runAsync(() -> movieRepository.save(converter.convert(movieRequest)));
    }
}
