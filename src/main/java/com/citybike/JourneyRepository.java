package com.citybike;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface JourneyRepository extends CrudRepository<Journey, Long> {

    @Query("SELECT j FROM Journey j JOIN FETCH j.Departure_station ORDER BY j.Duration ASC LIMIT 1")
    Journey findOneJourney();
}