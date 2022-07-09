package demo.tripadvisorapp.api;

import demo.tripadvisorapp.models.PackageHoliday;
import demo.tripadvisorapp.services.PackageHolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/packageHoliday")
public class PackageHolidayAPI {

    @Autowired
    private PackageHolidayService packageHolidayService;

    @GetMapping("/getRandomEscortedTours")
    public List<PackageHoliday> getRandomEscortedTours() {
        return packageHolidayService.getRandomEscortedTours();
    }

    @GetMapping("/getRandomIndependentTours")
    public List<PackageHoliday> getRandomIndependentTours() {
        return packageHolidayService.getRandomIndependentTours();
    }


}
