package demo.tripadvisorapp.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("eventtravel")
public class EventTravel {

    @Id
    private String id;
    private String title;
    private String description;
    private String typeOfEventTravel;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getTypeOfEventTravel() {
        return typeOfEventTravel;
    }
}
