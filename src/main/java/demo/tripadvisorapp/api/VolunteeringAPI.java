package demo.tripadvisorapp.api;

import demo.tripadvisorapp.models.Volunteering;
import demo.tripadvisorapp.services.VolunteeringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/volunteering")
public class VolunteeringAPI {

    @Autowired
    private VolunteeringService volunteeringService;

    @GetMapping("/getRandomChildcare")
    public List<Volunteering> getRandomChildcare() {
        return volunteeringService.getRandomChildcare();
    }

    @GetMapping("/getRandomConservationAndEnvironment")
    public List<Volunteering> getRandomConservationAndEnvironment() {
        return volunteeringService.getRandomConservationAndEnvironment();
    }
}
