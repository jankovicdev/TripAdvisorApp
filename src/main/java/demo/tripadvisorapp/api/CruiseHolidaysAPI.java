package demo.tripadvisorapp.api;

import demo.tripadvisorapp.models.CruiseHolidays;
import demo.tripadvisorapp.services.CruiseHolidaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/cruiseHolidays")
public class CruiseHolidaysAPI {

    @Autowired
    private CruiseHolidaysService cruiseHolidaysService;

    int countOceanCruising = 0;
    int countRiverCruising = 0;

    @GetMapping("/getRandomOceanCruising")
    public String getRandomOceanCruising(Model model) {
        countOceanCruising++;
        if (countOceanCruising <= cruiseHolidaysService.countCruiseHoliday("oceanCruising")) {
            model.addAttribute("randomOceanCruising", cruiseHolidaysService.findRandomCruiseHolidays("oceanCruising"));
            System.out.println("in if");
        } else {
            return "noMoreDoc";
        }
        return "randomOceanCruising";
    }

    @GetMapping("/getRandomRiverCruising")
    public String getRandomRiverCruising(Model model) {
        countRiverCruising++;
        if (countRiverCruising <= cruiseHolidaysService.countCruiseHoliday("riverCruising")) {
            model.addAttribute("randomRiverCruising", cruiseHolidaysService.findRandomCruiseHolidays("riverCruising"));
            System.out.println("in if");
        } else {
            return "noMoreDoc";
        }
        return "randomRiverCruising";
    }
}
