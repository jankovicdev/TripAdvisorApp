package demo.tripadvisorapp.services.impl;

import demo.tripadvisorapp.models.SkiingAndSnowBoarding;
import demo.tripadvisorapp.repository.SkiingAndSnowboardingRepository;
import demo.tripadvisorapp.services.SkiingAndSnowboardingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class SkiingAndSnowboardingServiceImpl implements SkiingAndSnowboardingService {

    @Autowired
    private SkiingAndSnowboardingRepository skiingAndSnowboardingRepository;

    @Override
    public List<SkiingAndSnowBoarding> getRandomBackcountrySkiing() {
        return Collections.singletonList(skiingAndSnowboardingRepository.randomBackcountrySkiing().getMappedResults().stream().findFirst().orElse(null));
    }

    @Override
    public List<SkiingAndSnowBoarding> getRandomDownhillSkiing() {
        return Collections.singletonList(skiingAndSnowboardingRepository.randomDownhillSkiing().getMappedResults().stream().findFirst().orElse(null));
    }
}
