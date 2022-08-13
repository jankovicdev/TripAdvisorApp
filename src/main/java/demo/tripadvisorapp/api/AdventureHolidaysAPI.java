package demo.tripadvisorapp.api;

import demo.tripadvisorapp.services.AdventureHolidaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/adventureHolidays")
public class AdventureHolidaysAPI {

    @Autowired
    private AdventureHolidaysService adventureHolidaysService;

    int countAPICallsSummerCamps = 0;
    int countAPICallsTrekking = 0;

    @GetMapping("/getRandomSummerCamps")
    public String getRandomSummerCamps(Model model) {
        countAPICallsSummerCamps++;
        if (countAPICallsSummerCamps <= adventureHolidaysService.countAdventureHolidays("summerCamps")) {
            model.addAttribute("randomSummerCamps", adventureHolidaysService.findRandomAdventureHolidays("summerCamps"));
            System.out.println("in if");
        } else {
            return "noMoreDoc";
        }
        return "randomSummerCamps";
    }


    @GetMapping("/getRandomTrekking")
    public String getRandomTrekking(Model model) {
        countAPICallsTrekking++;
        if (countAPICallsTrekking <= adventureHolidaysService.countAdventureHolidays("trekking")) {
            model.addAttribute("randomTrekkings", adventureHolidaysService.findRandomAdventureHolidays("trekking"));
            System.out.println("in if");
        } else {
            return "noMoreDoc";
        }
        return "randomTrekkings";
    }
}
