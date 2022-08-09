package demo.tripadvisorapp.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("safari")
public class Safari {

    @Id
    private String id;
    private String title;
    private String description;
    private String typeOfSafari;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getTypeOfSafari() {
        return typeOfSafari;
    }
}
