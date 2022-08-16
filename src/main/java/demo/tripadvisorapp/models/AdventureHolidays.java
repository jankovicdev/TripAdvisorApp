package demo.tripadvisorapp.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("adventureholidays")
public class AdventureHolidays {

    @Id
    private String id;
    private String title;
    private String description;
    private String state;
    private String typeOfAdventureHolidays;


    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getState() {
        return state;
    }


    public String getTypeOfAdventureHolidays() {
        return typeOfAdventureHolidays;
    }
}
