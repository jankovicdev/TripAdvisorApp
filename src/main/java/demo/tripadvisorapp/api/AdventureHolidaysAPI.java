package demo.tripadvisorapp.api;

import demo.tripadvisorapp.models.AdventureHolidays;
import demo.tripadvisorapp.services.AdventureHolidaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/adventureHolidays")
public class AdventureHolidaysAPI {

    @Autowired
    private AdventureHolidaysService adventureHolidaysService;

    @GetMapping("/getRandomSummerCamps")
    public List<AdventureHolidays> getRandomSummerCamps() {
        return adventureHolidaysService.getRandomSummerCamps();
    }

    @GetMapping("/getRandomTrekking")
    public List<AdventureHolidays> getRandomTrekking() {
        return adventureHolidaysService.getRandomTrekking();
    }
}
