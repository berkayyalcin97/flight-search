package tr.com.amadeus.flightservice.dto;

import jakarta.validation.constraints.Pattern;
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
    @Pattern(regexp = "DD:MM:YYYY HH:mm", message = "Please use the format DD:MM:YYYY HH:mm")
    private String departureDateTime;
    @Pattern(regexp = "DD:MM:YYYY HH:mm", message = "Please use the format DD:MM:YYYY HH:mm")
    private String returnDateTime;
    private double price;
}
