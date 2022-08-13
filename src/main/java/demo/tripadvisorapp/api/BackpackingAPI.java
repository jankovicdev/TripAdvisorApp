package demo.tripadvisorapp.api;

import demo.tripadvisorapp.models.Backpacking;
import demo.tripadvisorapp.services.AdventureHolidaysService;
import demo.tripadvisorapp.services.BackpackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/backpacking")
public class BackpackingAPI {

    @Autowired
    private BackpackingService backpackingService;

    int countLongDistanceHiking = 0;
    int countThruHiking = 0;

    @GetMapping("/getRandomLongDistanceHiking")
    public String getRandomLongDistanceHiking(Model model) {
        countLongDistanceHiking++;
        if (countLongDistanceHiking <= backpackingService.countBackpacking("longDistanceHiking")) {
            model.addAttribute("randomLongDistanceHiking", backpackingService.findRandomBackpacking("longDistanceHiking"));
            System.out.println("in if");
        } else {
            return "noMoreDoc";
        }
        return "randomLongDistanceHiking";
    }


    @GetMapping("/getRandomThruHiking")
    public String getRandomTrekking(Model model) {
        countThruHiking++;
        if (countThruHiking <= backpackingService.countBackpacking("thruHiking")) {
            model.addAttribute("randomThruHiking", backpackingService.findRandomBackpacking("thruHiking"));
            System.out.println("in if");
        } else {
            return "noMoreDoc";
        }
        return "randomThruHiking";
    }
}
