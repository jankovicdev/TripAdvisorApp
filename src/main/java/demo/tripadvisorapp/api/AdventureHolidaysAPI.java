package demo.tripadvisorapp.api;

import demo.tripadvisorapp.models.AdventureHolidays;
import demo.tripadvisorapp.services.AdventureHolidaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/adventureHolidays")
public class AdventureHolidaysAPI {

    @Autowired
    private AdventureHolidaysService adventureHolidaysService;

    @GetMapping("/getRandomSummerCamps")
    public String getRandomSummerCamps(Model model) {
        model.addAttribute("randomSummerCamps", adventureHolidaysService.getRandomSummerCamps());
        return "randomSummerCamps";
    }

    @GetMapping("/getRandomTrekking")
    public String getRandomTrekking(Model model) {
        model.addAttribute("randomTrekking", adventureHolidaysService.getRandomSummerCamps());
        return "adventureholidays";
    }
}
