package tr.com.amadeus.flightservice.Job;

import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Comment;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import tr.com.amadeus.flightservice.service.FlightService;

@RequiredArgsConstructor
@Component
public class ScheduledJob {

    private final FlightService flightService;


    //every 2 min */2 * * * *
    @Scheduled(cron = "0 */2 * * * ?")
    public void executeScheduledJob() {
        flightService.fetchMockDataAndSaveToDatabase();
    }
}
