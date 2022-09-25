package com.assessment.theater.controller.onboarding;

import com.assessment.theater.model.city.CityRequest;
import com.assessment.theater.service.CinemaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class Onboarding {
    private static final String[] DISALLOWED_FIELDS = new String[] {};
    private final CinemaService cinemaService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setDisallowedFields(DISALLOWED_FIELDS);
    }

    @PostMapping("/cinema")
    public void onBoarding(@Valid @RequestBody CityRequest cityRequest) {
        cinemaService.onboardCinema(cityRequest);
    }


}
