package demo.tripadvisorapp.trips.services;

import demo.tripadvisorapp.trips.models.AdventureHolidays;
import org.springframework.web.multipart.MultipartFile;

public interface AdventureHolidaysService {

    AdventureHolidays findRandomAdventureHolidays(String type);

    long countAdventureHolidays(String type);

    String saveImage(MultipartFile file);

}