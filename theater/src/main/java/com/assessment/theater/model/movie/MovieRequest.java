package com.assessment.theater.model.movie;

import com.assessment.theater.entity.movie.MovieType;
import com.assessment.theater.model.ShowRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Builder
@Getter
public class MovieRequest {

    private final String title;
    private final String description;
    private final LocalTime duration;
    private final MovieType language;
    private final LocalDate releaseDate;
    private final String country;
    private final String genre;
    @Size(min = 1, max = 4)
    private final List<ShowRequest> shows;


    @JsonIgnore
    @AssertTrue
    public boolean isShowRequestValid() {
        boolean allMatch = shows.stream().allMatch(showRequest -> showRequest.getStartTime().isBefore(showRequest.getEndTime()));
        if (allMatch) {
            return shows.stream().allMatch(showRequest -> showRequest.getStartTime().until(showRequest.getEndTime(), ChronoUnit.HOURS) >= duration.getHour());
        }
        return false;
    }

}
