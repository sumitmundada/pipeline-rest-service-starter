package com.cognizant.academy.restservice.repository.defaultRepository;

import com.cognizant.academy.restservice.model.defaultModel.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Integer> {
}
