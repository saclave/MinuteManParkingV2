package com.example.MinuteManParking.controller;

import com.example.MinuteManParking.dto.ParkingSlotRequest;
import com.example.MinuteManParking.dto.ParkingSlotResponse;
import com.example.MinuteManParking.model.ParkingSlot;
import com.example.MinuteManParking.model.Ticket;
import com.example.MinuteManParking.service.ParkingSlotService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
        List<ParkingSlot> parkingSlots = parkingSlotService.getAll();
        return parkingSlots.stream().map(PARKING_SLOT_MAPPER::toResponse).collect(Collectors.toList());
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

    @GetMapping("/{id}/ticketList")
    public List<Ticket> getTicketList(@PathVariable Integer id) {
        return parkingSlotService.getTicketByParkingSlot(id);
    }
}
