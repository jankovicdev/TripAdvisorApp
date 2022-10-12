package demo.tripadvisorapp.trips.api;

import demo.tripadvisorapp.trips.services.CruiseHolidaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.atomic.AtomicInteger;

@Controller
@RequestMapping("/cruiseHolidays")
public class CruiseHolidaysAPI {

    @Autowired
    private CruiseHolidaysService cruiseHolidaysService;

    AtomicInteger countOceanCruising = new AtomicInteger();
    AtomicInteger countRiverCruising = new AtomicInteger();


    @GetMapping("/getRandomOceanCruising")
    public String getRandomOceanCruising(Model model) {
        countOceanCruising.incrementAndGet();
        if (getCountOceanCruising() <= cruiseHolidaysService.countCruiseHoliday("oceanCruising")) {
            model.addAttribute("randomOceanCruising", cruiseHolidaysService.findRandomCruiseHolidays("oceanCruising"));
            System.out.println("in if");
        } else {
            countOceanCruising.set(0);
            return "noMoreDoc";
        }
        return "randomOceanCruising";
    }

    @GetMapping("/getRandomRiverCruising")
    public String getRandomRiverCruising(Model model) {
        countRiverCruising.incrementAndGet();
        if (getCountRiverCruising() <= cruiseHolidaysService.countCruiseHoliday("riverCruising")) {
            model.addAttribute("randomRiverCruising", cruiseHolidaysService.findRandomCruiseHolidays("riverCruising"));
            System.out.println("in if");
        } else {
            countRiverCruising.set(0);
            return "noMoreDoc";
        }
        return "randomRiverCruising";
    }
    public int getCountOceanCruising() {
        return this.countOceanCruising.get();
    }

    public int getCountRiverCruising() {
        return this.countRiverCruising.get();
    }
}
