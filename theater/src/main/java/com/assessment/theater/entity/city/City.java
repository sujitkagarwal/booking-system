package com.assessment.theater.entity.city;

import com.assessment.theater.entity.cinema.Cinema;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Builder(toBuilder = true)
@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "state")
    private String state;

    @Column(name = "zip_code",unique = true)
    private String zipCode;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "city",cascade = CascadeType.PERSIST)
    private List<Cinema> cinema;
}
