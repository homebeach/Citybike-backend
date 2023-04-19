package com.citybike.repository;

import com.citybike.model.JourneyDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JourneyRepository extends JpaRepository<JourneyDTO, Long> {

}
