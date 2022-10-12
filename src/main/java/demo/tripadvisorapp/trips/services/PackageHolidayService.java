package demo.tripadvisorapp.trips.services;

import demo.tripadvisorapp.trips.models.PackageHoliday;

public interface PackageHolidayService {


    PackageHoliday findRandomPackageHoliday(String type);

    long countPackageHoliday(String type);


}
