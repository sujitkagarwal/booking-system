package com.assessment.theater.service.cinema;

import com.assessment.theater.model.city.CityRequest;

import java.util.concurrent.CompletableFuture;

public interface CinemaService {
 CompletableFuture<Void> onboardCinema(CityRequest cityRequest);
}
