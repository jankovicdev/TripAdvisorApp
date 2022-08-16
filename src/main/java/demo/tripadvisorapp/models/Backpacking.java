package demo.tripadvisorapp.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("backpacking")
public class Backpacking {

    @Id
    private String id;
    private String title;
    private String description;
    private String state;
    private String typeOfBackpacking;

    public String getTitle() {
        return title;
    }

    public String getState() {
        return state;
    }

    public String getDescription() {
        return description;
    }

    public String getTypeOfBackpacking() {
        return typeOfBackpacking;
    }
}
