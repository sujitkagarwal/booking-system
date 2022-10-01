package com.assessment.theater.service.search;

import com.assessment.theater.model.search.MovieResponse;
import com.assessment.theater.model.search.SearchCriteriaRequest;

import java.util.concurrent.CompletableFuture;

public interface SearchService {

    CompletableFuture<MovieResponse> findMovie(SearchCriteriaRequest searchCriteriaRequest);
}
