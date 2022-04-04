package com.example.bookingApp.entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PASSENGERS")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "passenger_id")
    private Integer passengerId;

    @Column(name = "passenger_firstname")
    private String firstName;

    @Column(name = "passenger_lastname")
    private String lastName;

    @Column(name = "seat_number")
    private Integer seatNumber;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Passenger passenger = (Passenger) o;
        return passengerId != null && Objects.equals(passengerId, passenger.passengerId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
