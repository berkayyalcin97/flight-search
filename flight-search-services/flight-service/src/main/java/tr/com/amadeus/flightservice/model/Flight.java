package tr.com.amadeus.flightservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Flight {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    private String departureAirport;
    private String arrivalAirport;
    @Pattern(regexp = "DD:MM:YYYY HH:mm", message = "Please use the format DD:MM:YYYY HH:mm")
    private String departureDateTime;
    @Pattern(regexp = "DD:MM:YYYY HH:mm", message = "Please use the format DD:MM:YYYY HH:mm")
    private String returnDateTime;
    private double price;

}
