package tr.com.amadeus.flightservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.com.amadeus.flightservice.model.Flight;

import java.util.UUID;

public interface FlightRepository extends JpaRepository<Flight, UUID> {
}
