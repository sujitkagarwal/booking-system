package com.assessment.theater.entity.cinema;


import com.assessment.theater.entity.city.City;
import lombok.*;

import javax.persistence.*;
import java.util.List;


@Data
@Builder(toBuilder = true)
@EqualsAndHashCode
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Cinema {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    private City city;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cinema",cascade = CascadeType.PERSIST )
    private List<CinemaHall> cinemaHalls;

}
