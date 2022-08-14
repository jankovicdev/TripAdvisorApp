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
import java.util.concurrent.atomic.AtomicInteger;

@Controller
@RequestMapping("/volunteering")
public class VolunteeringAPI {


    AtomicInteger countChildcare = new AtomicInteger();
    AtomicInteger countConservationAndEnvironment = new AtomicInteger();

    @Autowired
    private VolunteeringService volunteeringService;

    @GetMapping("/getRandomChildcare")
    public String getRandomChildcare(Model model) {
        countChildcare.incrementAndGet();
        if (getCuntChildcare() <= volunteeringService.countVolunteering("childcare")) {
            model.addAttribute("randomChildcare", volunteeringService.findRandomVolunteering("childcare"));
            System.out.println("in if");
        } else {
            countChildcare.set(0);
            return "noMoreDoc";
        }
        return "randomChildcare";
    }

    @GetMapping("/getRandomConservationAndEnvironment")
    public String getRandomConservationAndEnvironment(Model model) {
        countConservationAndEnvironment.incrementAndGet();
        if (getCountConservationAndEnvironment() <= volunteeringService.countVolunteering("conservationAndEnvironment")) {
            model.addAttribute("randomConservationAndEnvironment", volunteeringService.findRandomVolunteering("conservationAndEnvironment"));
            System.out.println("in if");
        } else {
            countConservationAndEnvironment.set(0);
            return "noMoreDoc";
        }
        return "randomConservationAndEnvironment";
    }

    public int getCuntChildcare() {
        return this.countChildcare.get();
    }

    public int getCountConservationAndEnvironment() {
        return this.countConservationAndEnvironment.get();
    }
}
