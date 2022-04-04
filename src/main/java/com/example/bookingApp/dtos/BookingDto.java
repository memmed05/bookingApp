package com.example.bookingApp.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDto {

    private Integer id;
    private String passengerFirstName;
    private String passengerLastName;
    private Integer passengerSeatNumber;
    private String destinationPoint;
    private LocalDate date;
    private LocalTime time;
}
