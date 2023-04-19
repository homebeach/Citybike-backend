package com.citybike.repository;

import com.citybike.model.JourneyDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface JourneyRepository extends CrudRepository<JourneyDTO, Long> {

}