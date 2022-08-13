package demo.tripadvisorapp.api;

import demo.tripadvisorapp.models.EventTravel;
import demo.tripadvisorapp.services.EventTravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/eventTravel")
public class EventTravelAPI {

    @Autowired
    private EventTravelService eventTravelService;

    int countSportEvents = 0;
    int countRecreationsEvents = 0;

    @GetMapping("/getRandomRecreationsEvents")
    public String getRandomRecreationsEvents(Model model) {
        countRecreationsEvents++;
        if (countRecreationsEvents <= eventTravelService.countEventTravel("recreationsEvents")) {
            model.addAttribute("randomRecreationsEvents", eventTravelService.findRandomEventTravel("recreationsEvents"));
            System.out.println("in if");
        } else {
            return "noMoreDoc";
        }
        return "randomRecreationsEvents";
    }

    @GetMapping("/getRandomSportsEvents")
    public String getRandomSportsEvents(Model model) {
        countSportEvents++;
        if (countSportEvents <= eventTravelService.countEventTravel("sportEvents")) {
            model.addAttribute("randomSportEvents", eventTravelService.findRandomEventTravel("sportEvents"));
            System.out.println("in if");
        } else {
            return "noMoreDoc";
        }
        return "randomSportEvents";
    }
}
