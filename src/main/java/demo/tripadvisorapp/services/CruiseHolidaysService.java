package demo.tripadvisorapp.services;

import demo.tripadvisorapp.models.Backpacking;
import demo.tripadvisorapp.models.CruiseHolidays;


public interface CruiseHolidaysService {

    CruiseHolidays findRandomCruiseHolidays(String type);

    long countCruiseHoliday(String type);

}
