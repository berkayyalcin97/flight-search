package tr.com.amadeus.flightservice.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tr.com.amadeus.flightservice.dto.FlightDto;
import tr.com.amadeus.flightservice.model.Flight;
import tr.com.amadeus.flightservice.repository.FlightRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor public class FlightService {

    private final FlightRepository flightRepository;

    public void createFlight(FlightDto flightDto) {
        Flight flight = Flight.builder()
                .departureAirport(flightDto.getDepartureAirport())
                .arrivalAirport(flightDto.getArrivalAirport())
                .departureDateTime(flightDto.getDepartureDateTime())
                .returnDateTime(flightDto.getReturnDateTime())
                .price(flightDto.getPrice())
                .build();
        flightRepository.save(flight);
    }

    public List<FlightDto> getAllFlights() {
        return flightRepository.findAll().stream().
                map(this::mapFlightToFlightDto).toList();
    }

    public FlightDto getFlightById(UUID id) {

        return flightRepository.findById(id).map(this::mapFlightToFlightDto)
                .orElseThrow(null);
    }

    public void updateFlight(UUID id, FlightDto flightDto) {

        Flight existingFlight = flightRepository.getById(id);

        existingFlight.setDepartureAirport(flightDto.getDepartureAirport());
        existingFlight.setArrivalAirport(flightDto.getArrivalAirport());
        existingFlight.setDepartureDateTime(flightDto.getDepartureDateTime());
        existingFlight.setReturnDateTime(flightDto.getReturnDateTime());
        existingFlight.setPrice(flightDto.getPrice());

        flightRepository.save(existingFlight);
    }

    public FlightDto mapFlightToFlightDto(Flight flight){

        return FlightDto.builder()
                .departureAirport(flight.getDepartureAirport())
                .arrivalAirport(flight.getArrivalAirport())
                .departureDateTime(flight.getDepartureDateTime())
                .returnDateTime(flight.getReturnDateTime())
                .price(flight.getPrice())
                .build();
    }
    public void deleteFlight(UUID id) {
        flightRepository.deleteById(id);
    }
}
