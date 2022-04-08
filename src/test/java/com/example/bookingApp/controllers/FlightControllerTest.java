package com.example.bookingApp.controllers;

import com.example.bookingApp.entities.Flight;
import com.example.bookingApp.services.FlightService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(FlightController.class)
class FlightControllerTest {

    @Autowired
   private MockMvc mockMvc;

    @MockBean
    private FlightService flightService;

    @Test
    void getAllFlights() throws Exception {
        List<Flight> flights=flightService.getAllFlights();

        when(flightService.getAllFlights()).thenReturn(flights);

        mockMvc.perform(get("/api/v1/flight/getAllFlights")).andDo(print()).andExpect(status().isOk());

    }

    @Test
    void getFlightById() throws Exception {
        Flight flight=flightService.getFlightById(1);
        when(flightService.getFlightById(1)).thenReturn(flight);

        mockMvc.perform(get("/api/v1/flight/getFlightById?flightId=1")).andDo(print()).andExpect(status().isOk());
    }

}