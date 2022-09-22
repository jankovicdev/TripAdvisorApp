package demo.tripadvisorapp.api;

import demo.tripadvisorapp.models.AdventureHolidays;
import demo.tripadvisorapp.services.AdventureHolidaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
            model.addAttribute("randomSummerCamps", adventureHolidaysService.findRandomAdventureHolidays("summerCamps"));
            System.out.println("in if");
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

    @PostMapping("/photos/add")
    public String addPhoto(@RequestParam("file") MultipartFile file)
            throws IOException {
        return adventureHolidaysService.saveImage(file);
    }

    public int getCountSummerCamps() {
        return this.countSummerCamps.get();
    }

    public int getCountTrekkings() {
        return this.countTrekkings.get();
    }
}
