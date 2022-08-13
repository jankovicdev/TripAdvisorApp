package demo.tripadvisorapp.api;

import demo.tripadvisorapp.models.Volunteering;
import demo.tripadvisorapp.services.VolunteeringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/volunteering")
public class VolunteeringAPI {

    int countChildcare = 0;
    int countConservationAndEnvironment = 0;

    @Autowired
    private VolunteeringService volunteeringService;

    @GetMapping("/getRandomChildcare")
    public String getRandomChildcare(Model model) {
        countChildcare++;
        if (countChildcare <= volunteeringService.countVolunteering("childcare")) {
            model.addAttribute("randomChildcare", volunteeringService.findRandomVolunteering("childcare"));
            System.out.println("in if");
        } else {
            return "noMoreDoc";
        }
        return "randomChildcare";
    }

    @GetMapping("/getRandomConservationAndEnvironment")
    public String getRandomConservationAndEnvironment(Model model) {
        countConservationAndEnvironment++;
        if (countConservationAndEnvironment <= volunteeringService.countVolunteering("conservationAndEnvironment")) {
            model.addAttribute("randomConservationAndEnvironment", volunteeringService.findRandomVolunteering("conservationAndEnvironment"));
            System.out.println("in if");
        } else {
            return "noMoreDoc";
        }
        return "randomConservationAndEnvironment";
    }
}
