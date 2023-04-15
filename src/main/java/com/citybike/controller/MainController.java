package com.citybike.controller;

import com.citybike.repository.JourneyRepository;
import com.citybike.repository.StationRepository;
import com.citybike.model.JourneyDTO;
import com.citybike.model.JourneyWithStationsDTO;
import com.citybike.model.StationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping(path="/")
public class MainController {
    @Autowired
    private JourneyRepository journeyRepository;
    @Autowired
    private StationRepository stationRepository;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path="/journeys", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<JourneyWithStationsDTO>> getJourneys() {
        List<JourneyDTO> journeyDTOS = (List<JourneyDTO>) journeyRepository.findAll();
        List<JourneyWithStationsDTO> journeyDTOs = journeyDTOS.stream()
                .map(journey -> new JourneyWithStationsDTO(journey))
                .collect(Collectors.toList());
        HttpHeaders headers = new HttpHeaders();
        headers.add("total-pages", "1");
        return new ResponseEntity<>(journeyDTOs, headers, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path="/journey", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JourneyWithStationsDTO> getJourney() {
        JourneyDTO journeyDTO = journeyRepository.findOneJourney();
        return ResponseEntity.ok(new JourneyWithStationsDTO(journeyDTO));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path="/top5returnstations")
    public @ResponseBody Iterable<StationDTO> getTop5ReturnStationsByStationId(int stationId) {
        return stationRepository.findTop5ReturnStationsByStationId(stationId);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path="/top5departurestations")
    public @ResponseBody Iterable<StationDTO> getTop5DepartureStationsByStationId(int stationId) {
        return stationRepository.findTop5DepartureStationsByStationId(stationId);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path="/stations")
    public @ResponseBody Iterable<StationDTO> getAllStations() {
        return stationRepository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path="/station")
    public @ResponseBody Optional<StationDTO> getStation(Integer stationId) {
        Optional<StationDTO> station = stationRepository.findById(stationId);
        return stationRepository.findById(stationId);
    }

}