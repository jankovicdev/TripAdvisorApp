package demo.tripadvisorapp.api;

import demo.tripadvisorapp.models.PackageHoliday;
import demo.tripadvisorapp.services.PackageHolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Controller
@RequestMapping("/packageHoliday")
public class PackageHolidayAPI {


    AtomicInteger countEscortedTours = new AtomicInteger();
    AtomicInteger countIndependentTours = new AtomicInteger();

    @Autowired
    private PackageHolidayService packageHolidayService;

    @GetMapping("/getRandomEscortedTours")
    public String getRandomEscortedTours(Model model) {
        countEscortedTours.incrementAndGet();
        if (getCountEscortedTours() <= packageHolidayService.countPackageHoliday("escortedTours")) {
            model.addAttribute("randomEscortedTours", packageHolidayService.findRandomPackageHoliday("escortedTours"));
            System.out.println("in if");
        } else {
            countEscortedTours.set(0);
            return "noMoreDoc";
        }
        return "randomEscortedTours";
    }

    @GetMapping("/getRandomIndependentTours")
    public String getRandomIndependentTours(Model model) {
        countIndependentTours.incrementAndGet();
        if (getCountIndependentTours() <= packageHolidayService.countPackageHoliday("independentTours")) {
            model.addAttribute("randomIndependentTours", packageHolidayService.findRandomPackageHoliday("independentTours"));
            System.out.println("in if");
        } else {
            countIndependentTours.set(0);
            return "noMoreDoc";
        }
        return "randomIndependentTours";
    }

    public int getCountEscortedTours() {
        return this.countEscortedTours.get();
    }

    public int getCountIndependentTours() {
        return this.countIndependentTours.get();
    }

}
