package com.citybike;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.citybike.Station;
import com.citybike.StationRepository;
import com.citybike.MainController;
@SpringBootTest
class CityBikeApplicationTests {

	@Mock
	private StationRepository stationRepository;

	@Mock
	private JourneyRepository journeyRepository;

	@InjectMocks
	private MainController mainController;

	private Station station1;

	private Station station2;

	@BeforeEach
	void setUp() {
		station1 = new Station();
		station1.setId(1L);
		station1.setName("Station 1");

		station2 = new Station();
		station2.setId(2L);
		station2.setName("Station 2");
	}

	@Test
	public void testGetAllStations() {

		when(stationRepository.findAll()).thenReturn(Arrays.asList(station1, station2));

		Iterable<Station> result = mainController.getAllStations();

		assertNotNull(result);
		assertTrue(result.iterator().hasNext());
		assertEquals(2, ((List<Station>) result).size());
		assertEquals(station1, ((List<Station>) result).get(0));
		assertEquals(station2, ((List<Station>) result).get(1));
	}

	@Test
	public void testGetAllJourneys() {

		Journey journey1 = new Journey();
		journey1.setCovered_distance(20);
		journey1.setDuration(20);

		when(journeyRepository.findAll()).thenReturn(Arrays.asList(journey1));

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
