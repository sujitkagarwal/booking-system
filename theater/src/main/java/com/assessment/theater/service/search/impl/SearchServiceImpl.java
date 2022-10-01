package com.assessment.theater.service.search.impl;

import com.assessment.theater.entity.city.City;
import com.assessment.theater.model.search.MovieResponse;
import com.assessment.theater.model.search.SearchCriteriaRequest;
import com.assessment.theater.repository.city.CityRepository;
import com.assessment.theater.service.search.SearchService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@AllArgsConstructor
public class SearchServiceImpl implements SearchService {

    private final CityRepository cityRepository;
    @Override
    public CompletableFuture<MovieResponse> findMovie(SearchCriteriaRequest searchCriteriaRequest) {

        List<City> byName = cityRepository.findByName(searchCriteriaRequest.getValue());

      /*  byName.stream().map(city ->

                 city.getCinema().stream().map()


                )

        */
        return CompletableFuture.completedFuture(MovieResponse.builder().build());
    }
}
