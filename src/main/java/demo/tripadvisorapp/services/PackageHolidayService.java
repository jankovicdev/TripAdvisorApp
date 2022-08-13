package demo.tripadvisorapp.services;

import demo.tripadvisorapp.models.EventTravel;
import demo.tripadvisorapp.models.PackageHoliday;

import java.util.List;

public interface PackageHolidayService {


    PackageHoliday findRandomPackageHoliday(String type);

    long countPackageHoliday(String type);


}
