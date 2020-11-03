package com.example.MinuteManParking.controller;

import com.example.MinuteManParking.dto.HazardRequest;
import com.example.MinuteManParking.dto.HazardResponse;
import com.example.MinuteManParking.model.Hazard;
import com.example.MinuteManParking.service.HazardService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.MinuteManParking.mapper.HazardMapper.HAZARD_MAPPER;

@RestController
@RequestMapping("/hazards")
public class HazardController {
    private final HazardService hazardService;

    public HazardController(HazardService hazardService) {
        this.hazardService = hazardService;
    }

    @GetMapping
    public List<HazardResponse> getAll() {
        List<Hazard> hazards = hazardService.getAll();
        return hazards.stream().map(HAZARD_MAPPER::toResponse).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public HazardResponse getById(@PathVariable Integer id) {
        Hazard hazard = hazardService.retrieve(id);
        return HAZARD_MAPPER.toResponse(hazard);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public HazardResponse add(@RequestBody HazardRequest hazardRequest) {
        Hazard hazard = hazardService.create(HAZARD_MAPPER.toEntity(hazardRequest));
        return HAZARD_MAPPER.toResponse(hazard);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        hazardService.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public HazardResponse updateById(@PathVariable Integer id, @RequestBody HazardRequest hazardRequest) {
        Hazard hazard = hazardService.update(id, HAZARD_MAPPER.toEntity(hazardRequest));
        return HAZARD_MAPPER.toResponse(hazard);
    }

    @GetMapping("/type/{type}")
    public List<HazardResponse> getByType(@PathVariable String type) {
        List<Hazard> hazards = hazardService.findByType(type);
        return hazards.stream().map(HAZARD_MAPPER::toResponse).collect(Collectors.toList());
    }
}
