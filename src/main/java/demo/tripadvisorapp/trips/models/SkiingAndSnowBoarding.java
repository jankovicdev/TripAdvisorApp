package demo.tripadvisorapp.trips.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("skiingandsnowboarding")
public class SkiingAndSnowBoarding {

    @Id
    private String id;
    private String title;
    private String description;
    private String typeOfSkiingAndSnowboarding;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getTypeOfSkiingAndSnowboarding() {
        return typeOfSkiingAndSnowboarding;
    }
}
