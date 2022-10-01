package com.assessment.theater.controller.search;

import com.assessment.theater.model.search.MovieResponse;
import com.assessment.theater.model.search.SearchCriteriaRequest;
import com.assessment.theater.service.search.SearchService;
import lombok.AllArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import java.util.concurrent.CompletableFuture;

import static com.assessment.theater.util.Validator.checkSuppressedFields;

@RestController
@AllArgsConstructor
public class SearchController {

    private static final String[] SEARCH_ALLOWED_FIELDS = new String[]{"type", "value"};

    private final SearchService searchService;

    @InitBinder("search")
    public void initCarDetailsBinder(WebDataBinder binder) {
        binder.setAllowedFields(SEARCH_ALLOWED_FIELDS);
    }


    public CompletableFuture<MovieResponse> searchMovie(@Valid SearchCriteriaRequest searchCriteriaRequest, BindingResult bindingResult) {
        checkSuppressedFields(bindingResult);
        return searchService.findMovie(searchCriteriaRequest);
    }


}


