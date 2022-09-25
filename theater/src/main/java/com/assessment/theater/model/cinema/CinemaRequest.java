package com.assessment.theater.model.cinema;

import lombok.Builder;
import lombok.Getter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Builder
@Getter
public class CinemaRequest {

    private final String name;

    @Valid
    @NotNull
    @Size(min =1,max = 3)
    private final List<CinemaHallRequest> cinemaHalls;

}
