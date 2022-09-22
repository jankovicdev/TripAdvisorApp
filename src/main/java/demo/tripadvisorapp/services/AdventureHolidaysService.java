package demo.tripadvisorapp.services;

import demo.tripadvisorapp.models.AdventureHolidays;
import org.springframework.web.multipart.MultipartFile;

public interface AdventureHolidaysService {

    AdventureHolidays findRandomAdventureHolidays(String type);

    long countAdventureHolidays(String type);

    String saveImage(MultipartFile file);

}