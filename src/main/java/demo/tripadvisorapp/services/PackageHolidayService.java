package demo.tripadvisorapp.services;

import demo.tripadvisorapp.models.PackageHoliday;

import java.util.List;

public interface PackageHolidayService {


    List<PackageHoliday> getRandomIndependentTours();
    List<PackageHoliday> getRandomEscortedTours();


}
