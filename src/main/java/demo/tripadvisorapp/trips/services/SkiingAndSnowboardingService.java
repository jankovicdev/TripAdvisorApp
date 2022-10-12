package demo.tripadvisorapp.trips.services;

import demo.tripadvisorapp.trips.models.SkiingAndSnowBoarding;

public interface SkiingAndSnowboardingService {

    SkiingAndSnowBoarding findRandomSkiingAndSnowboarding(String type);

    long countSkiingAndSnowboarding(String type);

}
