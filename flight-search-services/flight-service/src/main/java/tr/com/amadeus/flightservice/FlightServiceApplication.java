package tr.com.amadeus.flightservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@OpenAPIDefinition(
        info = @Info(
                description = "Flight Service API",
                version ="v1",
                title = "Flight Service API"
        ),
        servers = {@Server(url="http://localhost:8080/api/flight-service")}
)
@SpringBootApplication
@EnableDiscoveryClient
public class FlightServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlightServiceApplication.class, args);
    }

}
