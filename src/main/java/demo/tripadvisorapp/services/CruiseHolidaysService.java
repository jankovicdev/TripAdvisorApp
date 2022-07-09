package demo.tripadvisorapp.services;

import demo.tripadvisorapp.models.CruiseHolidays;

import java.util.List;

public interface CruiseHolidaysService {

    List<CruiseHolidays> getRandomOceanCruising();

    List<CruiseHolidays> getRandomRiverCruising();

}
