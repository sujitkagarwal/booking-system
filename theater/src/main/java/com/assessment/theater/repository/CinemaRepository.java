package com.assessment.theater.repository;

import com.assessment.theater.entity.city.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CinemaRepository extends JpaRepository<City, Long> {
}
