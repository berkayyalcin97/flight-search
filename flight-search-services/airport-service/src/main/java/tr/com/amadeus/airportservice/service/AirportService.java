package tr.com.amadeus.airportservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tr.com.amadeus.airportservice.dto.AirportDto;
import tr.com.amadeus.airportservice.model.Airport;
import tr.com.amadeus.airportservice.repository.AirportRepository;


import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AirportService {

    private final AirportRepository airportRepository;

    public void createAirport(AirportDto airportDto) {
        Airport airport = Airport.builder()
                .city(airportDto.getCity())
                .build();
        airportRepository.save(airport);
    }

    public List<AirportDto> getAllAirports() {
        return airportRepository.findAll().stream().
                map(this::mapAirportToAirportDto).toList();
    }

    public AirportDto getAirportById(UUID id) {

        return airportRepository.findById(id).map(this::mapAirportToAirportDto)
                .orElseThrow(null);
    }

    public void updateAirport(UUID id, AirportDto airportDto) {

        Airport existingAirport = airportRepository.getById(id);

        existingAirport.setCity(airportDto.getCity());
        airportRepository.save(existingAirport);
    }

    public AirportDto mapAirportToAirportDto(Airport airport){

        return AirportDto.builder()
                .city(airport.getCity())
                .build();
    }
    public void deleteAirport(UUID id) {
        airportRepository.deleteById(id);
    }
}
