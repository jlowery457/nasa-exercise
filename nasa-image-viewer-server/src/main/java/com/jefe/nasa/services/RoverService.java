package com.jefe.nasa.services;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.jefe.nasa.beans.RoverList;
import com.jefe.nasa.client.NasaRestClient;

@Component
public class RoverService {
	
	@Inject
	private NasaRestClient nasaRestClient;
	
	public RoverList getRoverList() {
		return nasaRestClient.getRoverList();
	}

}
