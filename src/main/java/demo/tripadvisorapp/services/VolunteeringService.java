package demo.tripadvisorapp.services;

import demo.tripadvisorapp.models.PackageHoliday;
import demo.tripadvisorapp.models.Volunteering;

import java.util.List;

public interface VolunteeringService {

    Volunteering findRandomVolunteering(String type);

    long countVolunteering(String type);

}
