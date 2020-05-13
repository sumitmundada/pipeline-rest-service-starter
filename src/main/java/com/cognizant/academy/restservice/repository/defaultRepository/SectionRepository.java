package com.cognizant.academy.restservice.repository.defaultRepository;

import com.cognizant.academy.restservice.model.defaultModel.Section;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectionRepository extends JpaRepository<Section, Integer> {
}
