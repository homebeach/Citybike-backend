package com.citybike;

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
        List<Journey> journeys = (List<Journey>) journeyRepository.findAll();
        List<JourneyWithStationsDTO> journeyDTOs = journeys.stream()
                .map(journey -> new JourneyWithStationsDTO(journey))
                .collect(Collectors.toList());
        HttpHeaders headers = new HttpHeaders();
        headers.add("total-pages", "1");
        return new ResponseEntity<>(journeyDTOs, headers, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path="/journey", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JourneyWithStationsDTO> getJourney() {
        Journey journey = journeyRepository.findOneJourney();
        return ResponseEntity.ok(new JourneyWithStationsDTO(journey));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path="/top5returnstations")
    public @ResponseBody Iterable<Station> getTop5ReturnStationsByStationId(int stationId) {
        return stationRepository.findTop5ReturnStationsByStationId(stationId);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path="/top5departurestations")
    public @ResponseBody Iterable<Station> getTop5DepartureStationsByStationId(int stationId) {
        return stationRepository.findTop5DepartureStationsByStationId(stationId);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path="/stations")
    public @ResponseBody Iterable<Station> getAllStations() {
        return stationRepository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path="/station")
    public @ResponseBody Optional<Station> getStation(Integer stationId) {
        Optional<Station> station = stationRepository.findById(stationId);
        return stationRepository.findById(stationId);
    }

}