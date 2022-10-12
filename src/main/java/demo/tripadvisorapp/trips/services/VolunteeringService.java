package demo.tripadvisorapp.trips.services;

import demo.tripadvisorapp.trips.models.Volunteering;

public interface VolunteeringService {

    Volunteering findRandomVolunteering(String type);

    long countVolunteering(String type);

}
