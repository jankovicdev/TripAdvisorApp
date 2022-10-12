package demo.tripadvisorapp.trips.services;

import demo.tripadvisorapp.trips.models.CruiseHolidays;


public interface CruiseHolidaysService {

    CruiseHolidays findRandomCruiseHolidays(String type);

    long countCruiseHoliday(String type);

}
