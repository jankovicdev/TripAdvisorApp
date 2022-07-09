package demo.tripadvisorapp.api;

import demo.tripadvisorapp.models.EventTravel;
import demo.tripadvisorapp.services.EventTravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/eventTravel")
public class EventTravelAPI {

    @Autowired
    private EventTravelService eventTravelService;

    @GetMapping("/getRandomRecreationsEvents")
    public List<EventTravel> getRandomRecreationsEvents() {
        return eventTravelService.getRandomRecreationsEvents();
    }

    @GetMapping("/getRandomSportsEvents")
    public List<EventTravel> getRandomSportsEvents() {
        return eventTravelService.getRandomSportsEvents();
    }
}
