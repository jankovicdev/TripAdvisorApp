package demo.tripadvisorapp.services;

import demo.tripadvisorapp.models.AdventureHolidays;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface AdventureHolidaysService {

    AdventureHolidays findRandomAdventureHolidays(String type);

    long countAdventureHolidays(String type);

    public AdventureHolidays getPhoto();

    public String addPhoto(MultipartFile file) throws IOException;

}