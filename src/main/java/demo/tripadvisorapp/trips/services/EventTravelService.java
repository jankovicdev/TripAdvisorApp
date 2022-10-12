package demo.tripadvisorapp.trips.services;

import demo.tripadvisorapp.trips.models.EventTravel;

public interface EventTravelService {

    EventTravel findRandomEventTravel(String type);

    long countEventTravel(String type);

}
