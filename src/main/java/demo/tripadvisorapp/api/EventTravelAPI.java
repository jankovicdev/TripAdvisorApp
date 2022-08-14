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
import java.util.concurrent.atomic.AtomicInteger;

@Controller
@RequestMapping("/eventTravel")
public class EventTravelAPI {

    @Autowired
    private EventTravelService eventTravelService;

    AtomicInteger countSportEvents = new AtomicInteger();
    AtomicInteger countRecreationsEvents = new AtomicInteger();

    @GetMapping("/getRandomRecreationsEvents")
    public String getRandomRecreationsEvents(Model model) {
        countRecreationsEvents.incrementAndGet();
        if (getCountRecreationsEvents() <= eventTravelService.countEventTravel("recreationsEvents")) {
            model.addAttribute("randomRecreationsEvents", eventTravelService.findRandomEventTravel("recreationsEvents"));
            System.out.println("in if");
        } else {
            countRecreationsEvents.set(0);
            return "noMoreDoc";
        }
        return "randomRecreationsEvents";
    }

    @GetMapping("/getRandomSportsEvents")
    public String getRandomSportsEvents(Model model) {
        countSportEvents.incrementAndGet();
        if (getCountSportEvents() <= eventTravelService.countEventTravel("sportEvents")) {
            model.addAttribute("randomSportEvents", eventTravelService.findRandomEventTravel("sportEvents"));
            System.out.println("in if");
        } else {
            countSportEvents.set(0);
            return "noMoreDoc";
        }
        return "randomSportEvents";
    }

    public int getCountSportEvents() {
        return this.countSportEvents.get();
    }

    public int getCountRecreationsEvents() {
        return this.countRecreationsEvents.get();
    }
}
