package com.assessment.theater.service.search;

import com.assessment.theater.model.search.MovieResponse;
import com.assessment.theater.model.search.SearchCriteriaRequest;

public interface SearchService {

    MovieResponse findMovie(SearchCriteriaRequest searchCriteriaRequest);
}
