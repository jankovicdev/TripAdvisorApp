package demo.tripadvisorapp.trips.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("volunteering")
public class Volunteering {

    @Id
    private String id;
    private String title;
    private String description;
    private String typeOfVolunteering;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getTypeOfVolunteering() {
        return typeOfVolunteering;
    }
}
