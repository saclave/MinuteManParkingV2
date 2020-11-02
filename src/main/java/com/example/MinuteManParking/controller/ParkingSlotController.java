package com.example.MinuteManParking.controller;

import com.example.MinuteManParking.dto.ParkingSlotRequest;
import com.example.MinuteManParking.dto.ParkingSlotResponse;
import com.example.MinuteManParking.model.ParkingSlot;
import com.example.MinuteManParking.service.ParkingSlotService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.MinuteManParking.mapper.ParkingSlotMapper.PARKING_SLOT_MAPPER;

@RestController
@RequestMapping("/slots")
public class ParkingSlotController {
    private final ParkingSlotService parkingSlotService;

    public ParkingSlotController(ParkingSlotService parkingSlotService) {
        this.parkingSlotService = parkingSlotService;
    }

    @GetMapping
    public List<ParkingSlotResponse> getAll() {
        List<ParkingSlot> todoItems = parkingSlotService.getAll();
        return todoItems.stream().map(PARKING_SLOT_MAPPER::toResponse).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ParkingSlotResponse getById(@PathVariable Integer id) {
        ParkingSlot parkingSlot = parkingSlotService.retrieve(id);
        return PARKING_SLOT_MAPPER.toResponse(parkingSlot);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ParkingSlotResponse add(@RequestBody ParkingSlotRequest parkingSlotRequest) {
        ParkingSlot parkingSlot = parkingSlotService.create(PARKING_SLOT_MAPPER.toEntity(parkingSlotRequest));
        return PARKING_SLOT_MAPPER.toResponse(parkingSlot);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        parkingSlotService.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ParkingSlotResponse updateById(@PathVariable Integer id, @RequestBody ParkingSlotRequest parkingSlotRequest) {
        ParkingSlot parkingSlot = parkingSlotService.update(id, PARKING_SLOT_MAPPER.toEntity(parkingSlotRequest));
        return PARKING_SLOT_MAPPER.toResponse(parkingSlot);
    }

    @GetMapping(params = "parkingLotId")
    public List<ParkingSlotResponse> getParkingSlotsByParkingLot(@RequestParam("parkingLotId") Integer parkingLotId) {
        return parkingSlotService.getParkingSlotsByParkingLot(parkingLotId).stream()
                .map(PARKING_SLOT_MAPPER::toResponse)
                .collect(Collectors.toList());
    }
}
