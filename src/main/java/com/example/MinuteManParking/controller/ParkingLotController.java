package com.example.MinuteManParking.controller;

import com.example.MinuteManParking.dto.ParkingLotRequest;
import com.example.MinuteManParking.dto.ParkingLotResponse;
import com.example.MinuteManParking.model.ParkingLot;
import com.example.MinuteManParking.model.ParkingSlot;
import com.example.MinuteManParking.service.ParkingLotService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.MinuteManParking.mapper.ParkingLotMapper.PARKING_LOT_MAPPER;

@RestController
@RequestMapping("/lots")
public class ParkingLotController {
    private final ParkingLotService parkingLotService;

    public ParkingLotController(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    @GetMapping
    public List<ParkingLotResponse> getAll() {
        List<ParkingLot> parkingLots = parkingLotService.getAll();
        return parkingLots.stream().map(this::getResponseWithAvailableAndCapacity).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ParkingLotResponse getById(@PathVariable Integer id) {
        ParkingLot parkingLot = parkingLotService.retrieve(id);
        return getResponseWithAvailableAndCapacity(parkingLot);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ParkingLotResponse add(@RequestBody ParkingLotRequest parkingLotRequest) {
        ParkingLot parkingLot = parkingLotService.create(PARKING_LOT_MAPPER.toEntity(parkingLotRequest));
        return getResponseWithAvailableAndCapacity(parkingLot);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        parkingLotService.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ParkingLotResponse updateById(@PathVariable Integer id, @RequestBody ParkingLotRequest parkingLotRequest) {
        ParkingLot parkingLot = parkingLotService.update(id, PARKING_LOT_MAPPER.toEntity(parkingLotRequest));
        return getResponseWithAvailableAndCapacity(parkingLot);
    }

    @GetMapping("/{id}/slotList")
    public List<ParkingSlot> getParkingSlotList(@PathVariable Integer id) {
        return parkingLotService.getParkingSlotsByParkingLot(id);
    }

    public ParkingLotResponse getResponseWithAvailableAndCapacity(ParkingLot parkingLot){
        ParkingLotResponse parkingLotResponse = PARKING_LOT_MAPPER.toResponse(parkingLot);
        parkingLotResponse.setCapacity(parkingLot.getParkingSlotList().size());
        parkingLotResponse.setAvailable((int) parkingLot.getParkingSlotList().stream().filter(ParkingSlot::getAvailability).count());
        return parkingLotResponse;
    }
}
