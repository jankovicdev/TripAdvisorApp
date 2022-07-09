package demo.tripadvisorapp.api;


import demo.tripadvisorapp.models.PackageHoliday;
import demo.tripadvisorapp.models.Safari;
import demo.tripadvisorapp.services.PackageHolidayService;
import demo.tripadvisorapp.services.SafariService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/safari")
public class SafariAPI {

    @Autowired
    private SafariService safariService;

    @GetMapping("/getRandomPhotographicSafari")
    public List<Safari> getRandomPhotographicSafari() {
        return safariService.getRandomPhotographic();
    }

    @GetMapping("/getRandomCyclingSafari")
    public List<Safari> getRandomCyclingSafari() {
        return safariService.getRandomCycling();
    }

}
