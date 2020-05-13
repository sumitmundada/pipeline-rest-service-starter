package com.cognizant.academy.restservice.service.defaultService;

import com.cognizant.academy.restservice.model.defaultModel.Section;
import com.cognizant.academy.restservice.repository.defaultRepository.SectionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectionService {

    private SectionRepository sectionRepository;

    public SectionService(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }

    public List<Section> findAll() {
        return (List<Section>) sectionRepository.findAll();
    }
}
