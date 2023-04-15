package com.citybike;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

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
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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
		stationDTO1.setName("Station 1");

		stationDTO2 = new StationDTO();
		stationDTO2.setId(2L);
		stationDTO2.setName("Station 2");
	}

	@Test
	public void testGetAllStations() {

		when(stationRepository.findAll()).thenReturn(Arrays.asList(stationDTO1, stationDTO2));

		Iterable<StationDTO> result = mainController.getAllStations();

		assertNotNull(result);
		assertTrue(result.iterator().hasNext());
		assertEquals(2, ((List<StationDTO>) result).size());
		assertEquals(stationDTO1, ((List<StationDTO>) result).get(0));
		assertEquals(stationDTO2, ((List<StationDTO>) result).get(1));
	}

	@Test
	public void testGetAllJourneys() {

		JourneyDTO journeyDTO1 = new JourneyDTO();
		journeyDTO1.setCovered_distance(20);
		journeyDTO1.setDuration(20);

		when(journeyRepository.findAll()).thenReturn(Arrays.asList(journeyDTO1));

		ResponseEntity<Iterable<JourneyWithStationsDTO>> responseEntity = mainController.getJourneys();
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

		Iterable<JourneyWithStationsDTO> result = responseEntity.getBody();

		assertNotNull(result);
		assertTrue(result.iterator().hasNext());
		assertEquals(1, ((List<JourneyWithStationsDTO>) result).size());
		assertEquals(20, ((List<JourneyWithStationsDTO>) result).get(0).getCovered_distance());
		assertEquals(20, ((List<JourneyWithStationsDTO>) result).get(0).getDuration());
	}

}
