package demo.tripadvisorapp.services;

import demo.tripadvisorapp.models.PackageHoliday;
import demo.tripadvisorapp.models.SkiingAndSnowBoarding;

import java.util.List;

public interface SkiingAndSnowboardingService {

    SkiingAndSnowBoarding findRandomSkiingAndSnowboarding(String type);

    long countSkiingAndSnowboarding(String type);

}
