package demo.tripadvisorapp.api;

import demo.tripadvisorapp.models.Backpacking;
import demo.tripadvisorapp.services.BackpackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/backpacking")
public class BackpackingAPI {


    @Autowired
    private BackpackingService backpackingService;

    @GetMapping("/getRandomLongDistanceHiking")
    public List<Backpacking> getRandomLongDistanceHiking() {
        return backpackingService.getRandomLongDistanceHiking();
    }

    @GetMapping("/getRandomThruHiking")
    public List<Backpacking> getRandomThruHiking() {
        return backpackingService.getRandomThruHiking();
    }

}
