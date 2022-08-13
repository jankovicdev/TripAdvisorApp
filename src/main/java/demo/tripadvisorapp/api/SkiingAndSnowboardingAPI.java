package demo.tripadvisorapp.api;

import demo.tripadvisorapp.models.SkiingAndSnowBoarding;
import demo.tripadvisorapp.services.SkiingAndSnowboardingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/skiingAndSnowboarding")
public class SkiingAndSnowboardingAPI {

    int countBackcountrySkiing = 0;
    int countDownhillSkiing = 0;

    @Autowired
    private SkiingAndSnowboardingService skiingAndSnowboardingService;

    @GetMapping("/getRandomBackcountrySkiing")
    public String getRandomBackcountrySkiing(Model model) {
        countBackcountrySkiing++;
        if (countBackcountrySkiing <= skiingAndSnowboardingService.countSkiingAndSnowboarding("backcountrySkiing")) {
            model.addAttribute("randomBackcountrySkiing", skiingAndSnowboardingService.findRandomSkiingAndSnowboarding("backcountrySkiing"));
            System.out.println("in if");
        } else {
            return "noMoreDoc";
        }
        return "randomBackcountrySkiing";
    }

    @GetMapping("/getRandomDownhillSkiing")
    public String getRandomDownhillSkiing(Model model) {
        countDownhillSkiing++;
        if (countDownhillSkiing <= skiingAndSnowboardingService.countSkiingAndSnowboarding("downhillSkiing")) {
            model.addAttribute("randomDownhillSkiing", skiingAndSnowboardingService.findRandomSkiingAndSnowboarding("downhillSkiing"));
            System.out.println("in if");
        } else {
            return "noMoreDoc";
        }
        return "randomDownhillSkiing";
    }

}
