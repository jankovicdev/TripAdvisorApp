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

@Controller
@RequestMapping("/packageHoliday")
public class PackageHolidayAPI {

    int countEscortedTours = 0;
    int countIndependentTours = 0;

    @Autowired
    private PackageHolidayService packageHolidayService;

    @GetMapping("/getRandomEscortedTours")
    public String getRandomEscortedTours(Model model) {
        countEscortedTours++;
        if (countEscortedTours <= packageHolidayService.countPackageHoliday("escortedTours")) {
            model.addAttribute("randomEscortedTours", packageHolidayService.findRandomPackageHoliday("escortedTours"));
            System.out.println("in if");
        } else {
            return "noMoreDoc";
        }
        return "randomEscortedTours";
    }

    @GetMapping("/getRandomIndependentTours")
    public String getRandomIndependentTours(Model model) {
        countIndependentTours++;
        if (countIndependentTours <= packageHolidayService.countPackageHoliday("independentTours")) {
            model.addAttribute("randomIndependentTours", packageHolidayService.findRandomPackageHoliday("independentTours"));
            System.out.println("in if");
        } else {
            return "noMoreDoc";
        }
        return "randomIndependentTours";
    }


}
