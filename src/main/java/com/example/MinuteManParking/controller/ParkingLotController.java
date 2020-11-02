package com.example.MinuteManParking.controller;

import com.example.MinuteManParking.dto.ParkingLotRequest;
import com.example.MinuteManParking.dto.ParkingLotResponse;
import com.example.MinuteManParking.mapper.ParkingLotMapper;
import com.example.MinuteManParking.model.ParkingLot;
import com.example.MinuteManParking.service.ParkingLotService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/lots")
public class ParkingLotController {
    private final ParkingLotService parkingLotService;
    private final ParkingLotMapper parkingLotMapper;

    public ParkingLotController(ParkingLotService parkingLotService, ParkingLotMapper parkingLotMapper) {
        this.parkingLotService = parkingLotService;
        this.parkingLotMapper = parkingLotMapper;
    }

    @GetMapping
    public List<ParkingLotResponse> getAll() {
        List<ParkingLot> parkingLots = parkingLotService.getAll();
        return parkingLots.stream().map(parkingLotMapper::toResponse).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ParkingLotResponse getById(@PathVariable Integer id) {
        ParkingLot parkingLot = parkingLotService.retrieve(id);
        return parkingLotMapper.toResponse(parkingLot);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ParkingLotResponse add(@RequestBody ParkingLotRequest parkingLotRequest) {
        ParkingLot parkingLot = parkingLotService.create(parkingLotMapper.toEntity(parkingLotRequest));
        return parkingLotMapper.toResponse(parkingLot);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        parkingLotService.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ParkingLotResponse updateById(@PathVariable Integer id, @RequestBody ParkingLotRequest parkingLotRequest) {
        ParkingLot parkingLot = parkingLotService.update(id, parkingLotMapper.toEntity(parkingLotRequest));
        return parkingLotMapper.toResponse(parkingLot);
    }
}
