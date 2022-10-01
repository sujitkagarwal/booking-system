package com.assessment.theater.service.movie;

import com.assessment.theater.model.movie.MovieRequest;

import java.util.concurrent.CompletableFuture;

public interface MovieService {
    CompletableFuture<Void> addMovie(MovieRequest movieRequest);
}
