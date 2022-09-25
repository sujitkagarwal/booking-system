package com.assessment.theater.conversion.movie;

import com.assessment.theater.entity.Show;
import com.assessment.theater.entity.movie.Movie;
import com.assessment.theater.model.ShowRequest;
import com.assessment.theater.model.movie.MovieRequest;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class MovieRequestConversion implements Converter<MovieRequest, Movie> {

    private final Converter<ShowRequest, Show> showConverter;

    @Override
    public Movie convert(MovieRequest movieRequest) {
        Movie movie = Movie.builder()
                .title(movieRequest.getTitle())
                .description(movieRequest.getDescription())
                .country(movieRequest.getCountry())
                .language(movieRequest.getLanguage())
                .duration(movieRequest.getDuration())
                .releaseDate(movieRequest.getReleaseDate())
                .genre(movieRequest.getGenre())
                .build();
        movie.setShows(buildShow(movieRequest, movie));
        return movie;
    }

    private List<Show> buildShow(final MovieRequest movieRequest, final Movie movie) {
        return movieRequest.getShows().stream().map(showRequest -> {
            Show convert = showConverter.convert(showRequest);
            convert.setMovie(movie);
            return convert;
        }).collect(Collectors.toList());
    }
}
