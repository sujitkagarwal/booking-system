package com.assessment.theater.controller.onboarding;

import com.assessment.theater.model.city.CityRequest;
import com.assessment.theater.service.cinema.CinemaService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.concurrent.Computable;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.concurrent.CompletableFuture;

@RestController
@RequiredArgsConstructor
public class Onboarding {
    private static final String[] DISALLOWED_FIELDS = new String[]{};
    private final CinemaService cinemaService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setDisallowedFields(DISALLOWED_FIELDS);
    }

    @PostMapping("/cinema")
    public CompletableFuture<Void> onBoarding(@Valid @RequestBody final CityRequest cityRequest) {
        return  cinemaService.onboardCinema(cityRequest);
    }


}
