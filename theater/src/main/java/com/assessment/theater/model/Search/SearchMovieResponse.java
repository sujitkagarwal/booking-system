package com.assessment.theater.model.Search;

import com.assessment.theater.entity.movie.MovieType;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;

@Builder
@Getter
public class SearchMovieResponse {

    private final String title;
    private final String description;
    private final LocalTime duration;
    private final MovieType language;
    private final LocalDate releaseDate;
    private final String country;
    private final String genre;
    private final LocalTime startTime;
    private final LocalTime endTime;


}
