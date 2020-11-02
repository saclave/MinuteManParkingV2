package com.example.MinuteManParking.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class ParkingSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Boolean availability;
    private Integer parkingLotId;
    //TODO rename this
    private String parkingSlotName;
    @OneToMany(
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    @JoinColumn(name = "slotId")
    private List<Ticket> ticketList;

    public ParkingSlot() {

    }

    public ParkingSlot(Boolean availability, Integer parkingLotId, String parkingSlotName) {
        this.availability = availability;
        this.parkingLotId = parkingLotId;
        this.parkingSlotName = parkingSlotName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    public Integer getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(Integer parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public String getParkingSlotName() {
        return parkingSlotName;
    }

    public void setParkingSlotName(String parkingSlotName) {
        this.parkingSlotName = parkingSlotName;
    }
}
