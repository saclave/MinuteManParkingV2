package com.example.MinuteManParking.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class ParkingLot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double longitude;
    private Double latitude;
    private String address;
    private Double price;
    private String name;
    private String city;
    private String img_src;

    @OneToMany(
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    @JoinColumn(name = "parkingLotId")
    private List<ParkingSlot> parkingSlotList;

    public ParkingLot() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<ParkingSlot> getParkingSlotList() {
        return parkingSlotList;
    }

    public void setParkingSlotList(List<ParkingSlot> parkingSlotList) {
        this.parkingSlotList = parkingSlotList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgSrc() {
        return img_src;
    }

    public void setImgSrc(String img_src) {
        this.img_src = img_src;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
