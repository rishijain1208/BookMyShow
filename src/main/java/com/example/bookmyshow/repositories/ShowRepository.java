package com.example.bookmyshow.repositories;

import com.example.bookmyshow.models.Show;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShowRepository extends JpaRepository<Show,Long> {
    @Override
    Optional<Show> findById(Long id);
}
