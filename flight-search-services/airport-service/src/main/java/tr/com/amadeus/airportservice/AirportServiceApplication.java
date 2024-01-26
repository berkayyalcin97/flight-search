package tr.com.amadeus.airportservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@OpenAPIDefinition(
        info = @Info(
                description = "Airport Service API",
                version ="v1",
                title = "Airport Service API"
        ),
        servers = {@Server(url="http://localhost:8080/api/airport-service")}
)

@EnableDiscoveryClient
@SpringBootApplication
public class AirportServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AirportServiceApplication.class, args);
    }

}
