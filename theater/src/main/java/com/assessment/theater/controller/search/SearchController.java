package com.assessment.theater.controller.search;

import com.assessment.theater.model.Search.MovieResponse;
import com.assessment.theater.model.Search.SearchCriteriaRequest;
import lombok.AllArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
public class SearchController {

    private static final String[] SEARCH_ALLOWED_FIELDS = new String[]{"type", "value"};

    @InitBinder("search")
    public void initCarDetailsBinder(WebDataBinder binder) {
        binder.setAllowedFields(SEARCH_ALLOWED_FIELDS);
    }


    public MovieResponse searchMovie(@Valid SearchCriteriaRequest searchCriteriaRequest, BindingResult bindingResult) {

        //  checkSuppressedFields(bindingResult);

        return null;
    }


}


