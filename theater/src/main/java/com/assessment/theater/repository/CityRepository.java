package com.assessment.theater.repository;

import com.assessment.theater.entity.city.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {
    List<City> findByName(String name);
}
