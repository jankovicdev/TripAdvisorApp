package demo.tripadvisorapp.services;

import demo.tripadvisorapp.models.EventTravel;

import java.util.List;

public interface EventTravelService {

    List<EventTravel> getRandomSportsEvents();

    List<EventTravel> getRandomRecreationsEvents();

}
