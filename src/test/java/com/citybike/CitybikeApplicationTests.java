package com.citybike;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.citybike.controller.MainController;
import com.citybike.model.JourneyDTO;
import com.citybike.model.JourneyWithStationsDTO;
import com.citybike.model.StationDTO;
import com.citybike.repository.JourneyRepository;
import com.citybike.repository.StationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.test.web.servlet.MockMvc;

import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

@SpringBootTest
class CityBikeApplicationTests {

	@Mock
	private StationRepository stationRepository;

	@Mock
	private JourneyRepository journeyRepository;

	@InjectMocks
	private MainController mainController;

	private StationDTO stationDTO1;

	private StationDTO stationDTO2;

	@BeforeEach
	void setUp() {
		stationDTO1 = new StationDTO();
		stationDTO1.setId(1L);
		stationDTO1.setName("Station1");

		stationDTO2 = new StationDTO();
		stationDTO2.setId(2L);
		stationDTO2.setName("Station2");
	}

	@Test
	void testGetAllStations() {

		// create test data
		List<StationDTO> stationDTOs = new ArrayList<>();
		stationDTOs.add(stationDTO1);
		stationDTOs.add(stationDTO2);
		Page<StationDTO> pagedResult = new PageImpl<>(stationDTOs);

		// mock behavior of StationRepository.findAll
		when(stationRepository.findAll(any(PageRequest.class))).thenReturn(pagedResult);

		// call the method being tested
		Iterable<StationDTO> result = mainController.getAllStations(0, 10);

		// assert the result
		assertEquals(stationDTOs, result);
	}

	@Test
	public void testGetJourneys() {
		// create test data
		List<JourneyDTO> journeyDTOs = new ArrayList<>();
		JourneyDTO journeyDTO1 = new JourneyDTO();
		journeyDTO1.setCovered_distance(20);
		journeyDTO1.setDuration(20);
		journeyDTOs.add(journeyDTO1);
		Page<JourneyDTO> pagedResult = new PageImpl<>(journeyDTOs);

		// mock behavior of JourneyRepository.findAll
		when(journeyRepository.findAll(any(Pageable.class))).thenReturn(pagedResult);

		// call the method being tested
		ResponseEntity<List<JourneyWithStationsDTO>> responseEntity = mainController.getJourneys(0, 10);

		// assert the result
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		List<JourneyWithStationsDTO> result = responseEntity.getBody();
		assertNotNull(result);
		assertTrue(result.iterator().hasNext());
		assertEquals(1, result.size());
		assertEquals(20, result.get(0).getCovered_distance());
		assertEquals(20, result.get(0).getDuration());

		// verify headers
		HttpHeaders headers = responseEntity.getHeaders();
		assertNotNull(headers);
		assertEquals(1, headers.size());
		assertTrue(headers.containsKey("total-pages"));
		assertEquals("1", headers.getFirst("total-pages"));
	}
}
