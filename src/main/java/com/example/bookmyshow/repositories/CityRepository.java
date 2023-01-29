package com.example.bookmyshow.repositories;

import com.example.bookmyshow.models.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City,Long> {

    @Override
    City save(City city);

    @Override
    Optional<City> findById(Long id);

    List<City> findAllByName(String name);
}
