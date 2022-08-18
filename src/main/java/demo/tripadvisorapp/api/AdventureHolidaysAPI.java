package demo.tripadvisorapp.api;

import demo.tripadvisorapp.models.AdventureHolidays;
import demo.tripadvisorapp.services.AdventureHolidaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.concurrent.atomic.AtomicInteger;


@Controller
@RequestMapping("/adventureHolidays")
public class AdventureHolidaysAPI {

    @Autowired
    private AdventureHolidaysService adventureHolidaysService;

    AtomicInteger countSummerCamps = new AtomicInteger();
    AtomicInteger countTrekkings = new AtomicInteger();

    @GetMapping("/getRandomSummerCamps")
    public String getRandomSummerCamps(Model model) {

        countSummerCamps.incrementAndGet();
        if (getCountSummerCamps() <= adventureHolidaysService.countAdventureHolidays("summerCamps")) {
            AdventureHolidays photo = adventureHolidaysService.getPhoto();
            model.addAttribute("randomSummerCamps", adventureHolidaysService.findRandomAdventureHolidays("summerCamps"));
            System.out.println("in if");
            model.addAttribute("randomImage",
                    Base64.getEncoder().encodeToString(photo.getImage().getData()));
            return "randomSummerCamps";
        } else {
            countSummerCamps.set(0);
            return "noMoreDoc";
        }
    }

    @GetMapping("/getRandomTrekking")
    public String getRandomTrekking(Model model) {
        countTrekkings.incrementAndGet();
        if (getCountTrekkings() <= adventureHolidaysService.countAdventureHolidays("trekking")) {
            model.addAttribute("randomTrekkings", adventureHolidaysService.findRandomAdventureHolidays("trekking"));
            System.out.println("in if");
            return "randomTrekkings";
        } else {
            countTrekkings.set(0);
            return "noMoreDoc";

        }
    }

    public int getCountSummerCamps() {
        return this.countSummerCamps.get();
    }

    public int getCountTrekkings() {
        return this.countTrekkings.get();
    }
}
