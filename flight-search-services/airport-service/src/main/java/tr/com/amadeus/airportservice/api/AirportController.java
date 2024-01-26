package tr.com.amadeus.airportservice.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.com.amadeus.airportservice.dto.AirportDto;
import tr.com.amadeus.airportservice.service.AirportService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/airports")
@RequiredArgsConstructor
public class AirportController {

private final AirportService airportService;
    @PostMapping
    public ResponseEntity<Void> createAirport(@RequestBody AirportDto airportDto){
        airportService.createAirport(airportDto);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public ResponseEntity<List<AirportDto>> getAllAirports() {
        return ResponseEntity.ok(airportService.getAllAirports());
    }
    @GetMapping("/{id}")
    public ResponseEntity<AirportDto> getAirportById(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(airportService.getAirportById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateAirport(@PathVariable("id") UUID id, @RequestBody AirportDto airportDto) {
        airportService.updateAirport(id,airportDto);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAirport(@PathVariable("id") UUID id) {
        airportService.deleteAirport(id);
        return ResponseEntity.ok().build();
    }
}
