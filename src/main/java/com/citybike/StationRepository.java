package com.citybike;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StationRepository extends CrudRepository<Station, Integer> {

    @Query(value = "SELECT s.* FROM Journey j, Station s WHERE j.Departure_station_id=:stationId AND j.Return_station_id=s.ID GROUP BY j.Return_station_id ORDER BY count(j.Return_station_id) DESC LIMIT 5", nativeQuery = true)
    List<Station> findTop5ReturnStationsByStationId(@Param("stationId") int stationId);

    @Query(value = "SELECT s.* FROM Journey j, Station s WHERE j.Return_station_id=:stationId AND j.Departure_station_id=s.ID GROUP BY j.Departure_station_id ORDER BY count(j.Departure_station_id) DESC LIMIT 5", nativeQuery = true)
    List<Station> findTop5DepartureStationsByStationId(@Param("stationId") int stationId);


}