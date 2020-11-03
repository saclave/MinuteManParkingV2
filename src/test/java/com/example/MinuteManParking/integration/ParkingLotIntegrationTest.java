package com.example.MinuteManParking.integration;

import com.example.MinuteManParking.model.ParkingLot;
import com.example.MinuteManParking.repository.ParkingLotRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ParkingLotIntegrationTest {
    public static final String LOT_URI = "/lots";

    @Autowired
    ParkingLotRepository parkingLotRepository;

    @Autowired
    private MockMvc mockMvc;

    @AfterEach
    void tearDown() {
        parkingLotRepository.deleteAll();
    }

    @Test // CREATE
    void should_create_lot_when_create_lot_given_lot_details() throws Exception{
        //given
        String lotAsJson = "{\n" +
                "\"longitude\": 1.0,\n" +
                "\"latitude\": 2.0,\n" +
                "\"address\": \"123 Sesame Street\",\n" +
                "\"price\": 50.0,\n" +
                "\"name\": \"EPIC PARKING\"\n" +
                "}";
        //when
        //then
        mockMvc.perform(post(LOT_URI)
                .contentType(MediaType.APPLICATION_JSON)
                .content(lotAsJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.longitude").value(1.0))
                .andExpect(jsonPath("$.latitude").value(2.0))
                .andExpect(jsonPath("$.address").value("123 Sesame Street"))
                .andExpect(jsonPath("$.price").value(50.0))
                .andExpect(jsonPath("$.name").value("EPIC PARKING"));
    }


    // READ
    // UPDATE
    // DELETE
}
