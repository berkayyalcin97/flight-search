package tr.com.amadeus.flightservice.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tr.com.amadeus.flightservice.dto.FlightDto;
import tr.com.amadeus.flightservice.model.Flight;
import tr.com.amadeus.flightservice.repository.FlightRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor public class FlightService {

    private final FlightRepository flightRepository;

    public void createFlight(FlightDto flightDto) {
        Flight flight = mapFlightDtoToFlight(flightDto);
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


    public void fetchMockDataAndSaveToDatabase() {
        List<FlightDto> flights = mockApiRequest();
        for (FlightDto flightDto : flights) {
            Flight flight = mapFlightDtoToFlight(flightDto);
            flightRepository.save(flight);
        }
    }
    private List<FlightDto> mockApiRequest() {
        List<FlightDto> flights = new ArrayList<>();
        flights.add(new FlightDto("Amadeus Airport", "MockAirport", LocalDateTime.now(), LocalDateTime.now().plusHours(3), 200.0));
        flights.add(new FlightDto("Mock Airport", "Amadeus Airport", LocalDateTime.now().plusDays(1), LocalDateTime.now().plusDays(1).plusHours(4), 300.0));
        return flights;
    }

    private Flight mapFlightDtoToFlight(FlightDto flightDto) {
        Flight flight = Flight.builder()
                .departureAirport(flightDto.getDepartureAirport())
                .arrivalAirport(flightDto.getArrivalAirport())
                .departureDateTime(flightDto.getDepartureDateTime())
                .returnDateTime(flightDto.getReturnDateTime())
                .price(flightDto.getPrice()).build();
//        Flight flight = new Flight();
//        flight.setDepartureAirport(flightDto.getDepartureAirport());
//        flight.setArrivalAirport(flightDto.getArrivalAirport());
//        flight.setDepartureDateTime(flightDto.getDepartureDateTime());
//        flight.setReturnDateTime(flightDto.getReturnDateTime());
//        flight.setPrice(flightDto.getPrice());

        return flight;
    }
}
