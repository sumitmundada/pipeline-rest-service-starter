package com.cognizant.academy.restservice.service.defaultService;

import com.cognizant.academy.restservice.model.defaultModel.Location;
import com.cognizant.academy.restservice.repository.defaultRepository.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    private LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<Location> findAll() {
        return (List<Location>) locationRepository.findAll();
    }
}
