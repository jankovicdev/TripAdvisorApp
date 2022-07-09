package demo.tripadvisorapp.services;

import demo.tripadvisorapp.models.AdventureHolidays;

import java.util.List;

public interface AdventureHolidaysService {

    List<AdventureHolidays> getRandomSummerCamps();

    List<AdventureHolidays> getRandomTrekking();

}
