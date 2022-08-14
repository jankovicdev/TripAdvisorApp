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
import java.util.concurrent.atomic.AtomicInteger;

@Controller
@RequestMapping("/backpacking")
public class BackpackingAPI {

    @Autowired
    private BackpackingService backpackingService;

    AtomicInteger countLongDistanceHiking = new AtomicInteger();
    AtomicInteger countThruHiking = new AtomicInteger();


    @GetMapping("/getRandomLongDistanceHiking")
    public String getRandomLongDistanceHiking(Model model) {
        countLongDistanceHiking.incrementAndGet();
        if (getCountLongDistanceHiking() <= backpackingService.countBackpacking("longDistanceHiking")) {
            model.addAttribute("randomLongDistanceHiking", backpackingService.findRandomBackpacking("longDistanceHiking"));
            System.out.println("in if");
        } else {
            countLongDistanceHiking.set(0);
            return "noMoreDoc";
        }
        return "randomLongDistanceHiking";
    }


    @GetMapping("/getRandomThruHiking")
    public String getRandomTrekking(Model model) {
        countThruHiking.incrementAndGet();
        if (getCountThruHiking() <= backpackingService.countBackpacking("thruHiking")) {
            model.addAttribute("randomThruHiking", backpackingService.findRandomBackpacking("thruHiking"));
            System.out.println("in if");
        } else {
            countThruHiking.set(0);
            return "noMoreDoc";
        }
        return "randomThruHiking";
    }

    public int getCountLongDistanceHiking() {
        return this.countLongDistanceHiking.get();
    }

    public int getCountThruHiking() {
        return this.countThruHiking.get();
    }
}
