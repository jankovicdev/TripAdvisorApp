package demo.tripadvisorapp.api;

import demo.tripadvisorapp.models.CruiseHolidays;
import demo.tripadvisorapp.services.CruiseHolidaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cruiseHolidays")
public class CruiseHolidaysAPI {

    @Autowired
    private CruiseHolidaysService cruiseHolidaysService;

    @GetMapping("/getRandomOceanCruising")
    public List<CruiseHolidays> getRandomOceanCruising() {
        return cruiseHolidaysService.getRandomOceanCruising();
    }

    @GetMapping("/getRandomRiverCruising")
    public List<CruiseHolidays> getRandomRiverCruising() {
        return cruiseHolidaysService.getRandomRiverCruising();
    }
}
