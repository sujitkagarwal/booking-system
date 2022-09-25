package com.assessment.theater.model.cinema;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Builder
@Getter
public class CinemaHallRequest {

    private final String name;

    @Min(5)
    @Max(100)
    private final Integer totalNoSeat;


    @Valid
    @NotNull
    @Size(min = 5, max = 100)
    private final List<SeatRequest> cinemaSeat;


    @JsonIgnore
    @AssertTrue
    public boolean isCinemaSeatValid() {
        return totalNoSeat == cinemaSeat.size();
    }

}
