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

    //every 30 min */30 * * * *
    //every 10 min 0 */10 * * * ?
    //every 10 sec */10 * * * * *
    @Scheduled(cron = "0 */10 * * * ?")
    public void executeScheduledJob() {
        flightService.fetchMockDataAndSaveToDatabase();
    }
}
