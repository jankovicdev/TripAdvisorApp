package demo.tripadvisorapp.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("packageholiday")
public class PackageHoliday {

    @Id
    private String id;
    private String title;
    private String description;
    private String whatToDo;
    private String typeOfPackageHoliday;


    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getWhatToDo() {
        return whatToDo;
    }

    public String getTypeOfPackageHoliday() {
        return typeOfPackageHoliday;
    }
}
