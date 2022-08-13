package demo.tripadvisorapp.services;

import demo.tripadvisorapp.models.CruiseHolidays;
import demo.tripadvisorapp.models.EventTravel;

import java.util.List;

public interface EventTravelService {

    EventTravel findRandomEventTravel(String type);

    long countEventTravel(String type);

}
