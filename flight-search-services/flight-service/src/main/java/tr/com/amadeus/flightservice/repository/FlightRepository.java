package tr.com.amadeus.flightservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tr.com.amadeus.flightservice.model.Flight;

import java.util.List;
import java.util.UUID;

public interface FlightRepository extends JpaRepository<Flight, UUID> {

    @Query(value = "SELECT * FROM flight " +
            "WHERE departure_airport = :departureAirport " +
            "AND arrival_airport = :arrivalAirport " +
            "AND departure_date_time = :departureDateTime",
            nativeQuery = true)
    List<Flight> searchOneWayFlights(
            @Param("departureAirport") String departureAirport,
            @Param("arrivalAirport") String arrivalAirport,
            @Param("departureDateTime") String departureDateTime
    );

    @Query(value = "SELECT * FROM flight " +
            "WHERE departure_airport = :departureAirport " +
            "AND arrival_airport = :arrivalAirport " +
            "AND departure_date_time = :departureDateTime " +
            "AND return_date_time = :returnDateTime",
            nativeQuery = true)
    List<Flight> searchTwoWayFlights(
            @Param("departureAirport") String departureAirport,
            @Param("arrivalAirport") String arrivalAirport,
            @Param("departureDateTime") String departureDateTime,
            @Param("returnDateTime") String returnDateTime
    );
}
