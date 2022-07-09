package demo.tripadvisorapp.services;

import demo.tripadvisorapp.models.Volunteering;

import java.util.List;

public interface VolunteeringService {

    List<Volunteering> getRandomConservationAndEnvironment();

    List<Volunteering> getRandomChildcare();

}
