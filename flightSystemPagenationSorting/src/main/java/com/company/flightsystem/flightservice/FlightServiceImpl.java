package com.company.flightsystem.flightservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.company.flightsystem.entities.Flight;
import com.company.flightsystem.flightrepository.FlightRepository;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    FlightRepository flightRepository;

    @Override
    public Flight addFlightDetails(Flight flight) {

        return flightRepository.save(flight);
    }

    @Override
    public Flight updateFlightDetails(Integer flightNumber,
                                      Flight flight) {

        Optional<Flight> optionalFlight =
                flightRepository.findById(flightNumber);

        if (optionalFlight.isPresent()) {

            return flightRepository.save(flight);
        }

        return null;
    }

    @Override
    public Flight getFlightDetails(Integer flightNumber) {

        return flightRepository.findById(flightNumber)
                .orElse(null);
    }

    @Override
    public List<Flight> getAllFlightsDetails() {

        return flightRepository.findAll();
    }

    @Override
    public String deleteFlightDetails(Integer flightNumber) {

        Optional<Flight> optionalFlight =
                flightRepository.findById(flightNumber);

        if (optionalFlight.isPresent()) {

            flightRepository.deleteById(flightNumber);

            return "Flight details deleted successfully";
        }

        return "Flight not found";
    }

    @Override
    public Page<Flight> getAllFlights(Pageable pageable) {

        return flightRepository.findAll(pageable);
    }
}