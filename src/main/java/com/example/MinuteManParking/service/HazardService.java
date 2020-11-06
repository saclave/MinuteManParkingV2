package com.example.MinuteManParking.service;

import com.example.MinuteManParking.exceptions.HazardNotFound;
import com.example.MinuteManParking.model.Hazard;
import com.example.MinuteManParking.repository.HazardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.MinuteManParking.exceptions.ExceptionConstants.HAZARD_NOT_FOUND;

@Service
public class HazardService {
    private final HazardRepository hazardRepository;

    public HazardService(HazardRepository hazardRepository) {
        this.hazardRepository = hazardRepository;
    }

    public List<Hazard> getAll() {
        return hazardRepository.findAll();
    }

    public Hazard retrieve(Integer id) {
        return hazardRepository.findById(id)
                .orElseThrow(() -> new HazardNotFound(HAZARD_NOT_FOUND));
    }

    public Hazard create(Hazard hazard) {
        hazard.setType(hazard.getType().toUpperCase());
        return hazardRepository.save(hazard);
    }

    public void delete(Integer id) {
        retrieve(id);
        hazardRepository.deleteById(id);
    }

    public Hazard update(Integer id, Hazard hazard) {
        Hazard retrievedHazard = retrieve(id);
        retrievedHazard.setLongitude(hazard.getLongitude());
        retrievedHazard.setAddress(hazard.getAddress());
        retrievedHazard.setLatitude(hazard.getLatitude());
        retrievedHazard.setType(hazard.getType().toUpperCase());
        retrievedHazard.setName(hazard.getName());
        return hazardRepository.save(retrievedHazard);
    }

    public List<Hazard> findByType(String type) {
        return hazardRepository.findByType(type);
    }
}
