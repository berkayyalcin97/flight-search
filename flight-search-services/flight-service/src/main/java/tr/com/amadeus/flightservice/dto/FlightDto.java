package tr.com.amadeus.flightservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlightDto {
    private String departureAirport;
    private String arrivalAirport;
    private String departureDateTime;
    private String returnDateTime;
    private double price;
}
