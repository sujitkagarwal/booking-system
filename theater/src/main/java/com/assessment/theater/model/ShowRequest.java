package com.assessment.theater.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.AssertTrue;
import java.time.LocalDate;
import java.time.LocalTime;

@Builder
@Getter
public class ShowRequest {

    private final LocalDate date;

    private final LocalTime startTime;

    private final LocalTime endTime;

    private final long id;





}
