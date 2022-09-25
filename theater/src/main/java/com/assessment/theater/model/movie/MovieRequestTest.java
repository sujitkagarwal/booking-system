package com.assessment.theater.model.movie;

import com.assessment.theater.model.ShowRequest;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovieRequestTest {

@Test
public void isShowRequestValid() {

    MovieRequest build = MovieRequest.builder().shows(buildShows())
            .duration(LocalTime.of(02, 20, 00))
            .build();


  /*  LocalTime lt1 = LocalTime.of(8, 00, 00);

    LocalTime lt2 = LocalTime.of(14, 00, 00);

    long until = lt1.until(lt2, ChronoUnit.HOURS);

    System.out.println(until);
*/

    List<ShowRequest> showRequests = buildShows();
    boolean allMatch = showRequests.stream().allMatch(showRequest -> showRequest.getStartTime().isBefore(showRequest.getEndTime()));
    if (allMatch) {
        System.out.println("its true");
        allMatch= showRequests.stream().allMatch(showRequest -> showRequest.getStartTime().until(showRequest.getEndTime(), ChronoUnit.HOURS) >= build.getDuration().getHour());
    }
    System.out.println(allMatch);
}

    private List<ShowRequest> buildShows() {
        List<ShowRequest> showRequests=new ArrayList<>();

        showRequests.add(ShowRequest.builder().startTime(LocalTime.of(8,00,00))
                .endTime(LocalTime.of(11,00,00)).build());

        showRequests.add(ShowRequest.builder().startTime(LocalTime.of(12,00,00))
                .endTime(LocalTime.of(15,00,00)).build());


        return showRequests;

    }
}