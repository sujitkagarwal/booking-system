package com.assessment.theater.repository.cinema;

import com.assessment.theater.entity.cinema.Cinema;
import com.assessment.theater.entity.city.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Long> {
}
