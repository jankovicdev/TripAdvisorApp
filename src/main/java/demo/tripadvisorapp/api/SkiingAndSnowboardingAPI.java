package demo.tripadvisorapp.api;

import demo.tripadvisorapp.models.SkiingAndSnowBoarding;
import demo.tripadvisorapp.services.SkiingAndSnowboardingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/skiingAndSnowboarding")
public class SkiingAndSnowboardingAPI {

    @Autowired
    private SkiingAndSnowboardingService skiingAndSnowboardingService;

    @GetMapping("/getRandomBackcountrySkiing")
    public List<SkiingAndSnowBoarding> getRandomBackcountrySkiing() {
        return skiingAndSnowboardingService.getRandomBackcountrySkiing();
    }

    @GetMapping("/getRandomDownhillSkiing")
    public List<SkiingAndSnowBoarding> getRandomDownhillSkiing() {
        return skiingAndSnowboardingService.getRandomDownhillSkiing();
    }

}
