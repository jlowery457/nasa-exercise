package com.jefe.nasa;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.jefe.nasa.beans.Rover;
import com.jefe.nasa.beans.RoverList;
import com.jefe.nasa.endpoints.RoverEndpoint;
import com.jefe.nasa.services.RoverService;

public class RoverEndpointUnitTest {
	
	@InjectMocks
	private RoverEndpoint roverEndpoint;
	
	@Mock
	private RoverService roverService;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetRoverList() {
		Rover rover = new Rover();
		rover.setId("1");
		rover.setName("Curiosity");
		List<Rover> rovers = new ArrayList<Rover>(1);
		rovers.add(rover);
		
		RoverList roverList = new RoverList();
		roverList.setRovers(rovers);
		
		when(roverService.getRoverList()).thenReturn(roverList);
		
		RoverList rl = roverEndpoint.getRovers();
		
		verify(roverService).getRoverList();
		
		assertThat(rl.getRovers(), contains(rover));
	}

}
