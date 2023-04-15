package com.citybike.repository;

import com.citybike.model.JourneyDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface JourneyRepository extends CrudRepository<JourneyDTO, Long> {

    //@Query("SELECT j FROM Journey j JOIN FETCH j.Departure_station ORDER BY j.Duration ASC LIMIT 1")
    //JourneyDTO findOneJourney();
}