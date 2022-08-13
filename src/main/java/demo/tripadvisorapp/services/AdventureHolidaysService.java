package demo.tripadvisorapp.services;

import demo.tripadvisorapp.models.AdventureHolidays;

public interface AdventureHolidaysService {

    AdventureHolidays findRandomAdventureHolidays(String type);

    long countAdventureHolidays(String type);


}
