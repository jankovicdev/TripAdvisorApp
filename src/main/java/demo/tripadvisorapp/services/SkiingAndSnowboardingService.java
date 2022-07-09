package demo.tripadvisorapp.services;

import demo.tripadvisorapp.models.SkiingAndSnowBoarding;

import java.util.List;

public interface SkiingAndSnowboardingService {

    List<SkiingAndSnowBoarding> getRandomBackcountrySkiing();

    List<SkiingAndSnowBoarding> getRandomDownhillSkiing();

}
