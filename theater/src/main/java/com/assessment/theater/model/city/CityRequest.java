package com.assessment.theater.model.city;

import com.assessment.theater.model.cinema.CinemaRequest;
import com.assessment.theater.util.Validator;
import lombok.Builder;
import lombok.Getter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Builder
public class CityRequest {

    @NotNull
    private final String name;
    @NotNull
    private final String state;
    @NotNull
    @Pattern(regexp = Validator.ZIP_CODE_PATTERN)
    private final String zipCode;
    @Valid
    @Size(max = 1)
    private final List<CinemaRequest> cinemaRequests;
}

