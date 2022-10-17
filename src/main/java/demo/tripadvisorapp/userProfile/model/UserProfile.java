package demo.tripadvisorapp.userProfile.model;

import demo.tripadvisorapp.trips.models.AdventureHolidays;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document("userProfile")
@Getter
@Setter
public class UserProfile {

    @Id
    private String id;

    private String loggedUserId;

    private String email;

    @DBRef
    private List<AdventureHolidays> adventureHolidaysList = new ArrayList<>();


}
