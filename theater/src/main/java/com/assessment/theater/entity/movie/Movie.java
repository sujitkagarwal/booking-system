package com.assessment.theater.entity.movie;

import com.assessment.theater.entity.Show;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@Builder(toBuilder = true)
@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    private String title;

    private String description;

    private LocalTime duration;

    private MovieType language;

    private LocalDate releaseDate;

    private String country;

    private String genre;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "movie",cascade = CascadeType.PERSIST)
    private List<Show> shows;
}
