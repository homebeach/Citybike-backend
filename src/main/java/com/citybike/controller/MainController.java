package com.citybike.controller;

import com.citybike.repository.JourneyRepository;
import com.citybike.repository.StationRepository;
import com.citybike.model.JourneyDTO;
import com.citybike.model.JourneyWithStationsDTO;
import com.citybike.model.StationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public ResponseEntity<List<JourneyWithStationsDTO>> getJourneys(@RequestParam(defaultValue = "0") int page,
                                                                    @RequestParam(defaultValue = "10") int size) {
        Pageable paging = PageRequest.of(page, size);
        Page<JourneyDTO> pagedResult = journeyRepository.findAll(paging);
        if (pagedResult.hasContent()) {
                List<JourneyWithStationsDTO> journeyDTOs = pagedResult.getContent().stream()
                    .map(journey -> new JourneyWithStationsDTO(journey))
                    .collect(Collectors.toList());
            HttpHeaders headers = new HttpHeaders();
            headers.add("total-pages", String.valueOf(pagedResult.getTotalPages()));
            return new ResponseEntity<>(journeyDTOs, headers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path="/journeyscount")
    public @ResponseBody long getJourneysCount() {
        return journeyRepository.count();
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