package tr.com.amadeus.flightservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.com.amadeus.flightservice.dto.FlightDto;
import tr.com.amadeus.flightservice.service.FlightService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/flights")
@RequiredArgsConstructor
public class FlightController {

    private final FlightService flightService;

    @PostMapping
    public ResponseEntity<Void> createFlight(@RequestBody FlightDto flightDto){
        flightService.createFlight(flightDto);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public ResponseEntity<List<FlightDto>> getAllFlights() {
        return ResponseEntity.ok(flightService.getAllFlights());
    }
    @GetMapping("/{id}")
    public ResponseEntity<FlightDto> getFlightById(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(flightService.getFlightById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateFlight(@PathVariable("id") UUID id,
                                             @RequestBody FlightDto flightDto) {
        flightService.updateFlight(id,flightDto);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlight(@PathVariable("id") UUID id) {
        flightService.deleteFlight(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/search")
    public ResponseEntity<List<FlightDto>> searchFlights(@RequestParam String departureAirport,
                                      @RequestParam String arrivalAirport,
                                      @RequestParam String departureDateTime,
                                      @RequestParam(required = false) String returnDateTime) {
        return ResponseEntity.ok(flightService.searchFlights(departureAirport, arrivalAirport, departureDateTime, returnDateTime)) ;
    }
}
