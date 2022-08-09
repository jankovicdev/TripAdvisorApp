package demo.tripadvisorapp.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("cruiseholidays")
public class CruiseHolidays {

    @Id
    private String id;
    private String title;
    private String description;
    private String typeOfCruiseHolidays;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getTypeOfCruiseHolidays() {
        return typeOfCruiseHolidays;
    }
}
