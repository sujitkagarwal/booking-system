package com.assessment.theater.conversion;

import com.assessment.theater.entity.Show;
import com.assessment.theater.entity.cinema.CinemaHall;
import com.assessment.theater.model.ShowRequest;
import com.assessment.theater.repository.CinemaHallRepository;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class ShowRequestConversion implements Converter<ShowRequest, Show> {
    private final CinemaHallRepository cinemaHallRepository;

    @Override
    public Show convert(ShowRequest source) {

        Optional<CinemaHall> byId = cinemaHallRepository.findById(source.getId());
        CinemaHall cinemaHall = null;
        if (byId.isPresent()) {
            cinemaHall = byId.get();
        }
        return Show.builder()
                .date(source.getDate())
                .startTime(source.getStartTime())
                .endTime(source.getEndTime())
                .cinemaHall(cinemaHall)
                .build();
    }

}
