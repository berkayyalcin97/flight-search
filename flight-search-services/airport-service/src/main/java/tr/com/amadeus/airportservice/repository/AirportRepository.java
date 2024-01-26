package tr.com.amadeus.airportservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.com.amadeus.airportservice.model.Airport;

import java.util.UUID;

public interface AirportRepository extends JpaRepository<Airport, UUID> {
}
