package demo.tripadvisorapp.api;

import demo.tripadvisorapp.services.SkiingAndSnowboardingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.atomic.AtomicInteger;

@Controller
@RequestMapping("/skiingAndSnowboarding")
public class SkiingAndSnowboardingAPI {


    AtomicInteger countBackcountrySkiing = new AtomicInteger();
    AtomicInteger countDownhillSkiing = new AtomicInteger();

    @Autowired
    private SkiingAndSnowboardingService skiingAndSnowboardingService;

    @GetMapping("/getRandomBackcountrySkiing")
    public String getRandomBackcountrySkiing(Model model) {
        countBackcountrySkiing.incrementAndGet();
        if (getCountBackcountrySkiing() <= skiingAndSnowboardingService.countSkiingAndSnowboarding("backcountrySkiing")) {
            model.addAttribute("randomBackcountrySkiing", skiingAndSnowboardingService.findRandomSkiingAndSnowboarding("backcountrySkiing"));
            System.out.println("in if");
        } else {
            countBackcountrySkiing.set(0);
            return "noMoreDoc";
        }
        return "randomBackcountrySkiing";
    }

    @GetMapping("/getRandomDownhillSkiing")
    public String getRandomDownhillSkiing(Model model) {
        countDownhillSkiing.incrementAndGet();
        if (getCountDownhillSkiing() <= skiingAndSnowboardingService.countSkiingAndSnowboarding("downhillSkiing")) {
            model.addAttribute("randomDownhillSkiing", skiingAndSnowboardingService.findRandomSkiingAndSnowboarding("downhillSkiing"));
            System.out.println("in if");
        } else {
            countDownhillSkiing.set(0);
            return "noMoreDoc";
        }
        return "randomDownhillSkiing";
    }
    public int getCountBackcountrySkiing() {
        return this.countBackcountrySkiing.get();
    }

    public int getCountDownhillSkiing() {
        return this.countDownhillSkiing.get();
    }
}
