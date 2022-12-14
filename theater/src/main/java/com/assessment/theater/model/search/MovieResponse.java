package com.assessment.theater.model.search;

import lombok.Builder;
import lombok.Getter;
import lombok.Singular;

import java.util.List;

@Builder
@Getter
public class MovieResponse {
    @Singular
    List<SearchMovieResponse> searchMovieResponses;
}
