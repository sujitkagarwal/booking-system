package com.assessment.theater.conversion.cinema;

import com.assessment.theater.entity.cinema.CinemaSeat;
import com.assessment.theater.model.cinema.SeatRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CinemaSeatRequestConversion implements Converter<SeatRequest, CinemaSeat> {


    @Override
    public CinemaSeat convert(SeatRequest source) {
        return CinemaSeat.builder()
                .seatNumber(source.getSeatNumber())
                .seatType(source.getSeatType())
                .build();
    }
}
