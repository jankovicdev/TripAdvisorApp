package demo.tripadvisorapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class TripAdvisorAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(TripAdvisorAppApplication.class, args);
    }

}
