package com.assessment.theater.controller.movie;

import com.assessment.theater.model.movie.MovieRequest;
import com.assessment.theater.service.movie.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.concurrent.CompletableFuture;

@RestController
@RequiredArgsConstructor
public class MovieController {
    private static final String[] DISALLOWED_FIELDS = new String[] {};
    private final MovieService movieService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setDisallowedFields(DISALLOWED_FIELDS);
    }

    @PostMapping("/movie")
    public CompletableFuture<Void> addMovie(@Valid @RequestBody MovieRequest movieRequest){
       return movieService.addMovie(movieRequest);
    }
}
