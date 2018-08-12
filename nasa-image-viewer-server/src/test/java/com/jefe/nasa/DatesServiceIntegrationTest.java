package com.jefe.nasa;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jefe.nasa.services.DatesService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DatesServiceIntegrationTest {
	
	@Inject
	DatesService datesService;

	@Test
	public void getDatesTest() {
		String[] dates = {"2017-02-27","2018-06-02","2016-07-13"};
		
		assertThat(datesService.getDates(), containsInAnyOrder(dates));
	}
}
